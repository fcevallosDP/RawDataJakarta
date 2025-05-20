/** 
 * Ultima Menu Widget 
 */
PrimeFaces.widget.Ultima = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this._super(cfg);
        this.wrapper = $('.layout-wrapper');
        this.menuWrapper = $('.layout-menu-wrapper');
        this.menuButton = $('.layout-menu-button');
        this.menu = this.jq;
        this.rootMenuitems = this.menu.children('li');
        this.menuitems = this.menu.find('li');
        this.menuitemLinks = this.menuitems.children('a');
        this.menuClick = false;
        this.menuButtonClick = false;
        this.menuWrapperClick = false;
        this.menuActive = false;
        this.stateful = this.isStateful();
        this.mobileBreakpoint = parseFloat(this.getCSSVariable('--layout-mobile-breakpoint'));

        this.bindEvents();
        this.restoreMenuState();
    },
    
    bindEvents: function() {
        var $this = this;

        this.menuWrapper.off('click.menu').on('click.menu', function(e) {
            $this.menuWrapperClick = true;
        });

        this.menu.off('click.menu').on('click.menu', function(e) {
            $this.menuClick = true;
        });

        this.menuButton.off('click.menu').on('click.menu', function(e) {
            $this.toggleMenuActive();

            clearTimeout($this.resizeTimeout);
            $this.resizeTimeout = setTimeout(function() {
                $(window).trigger('resize'); // For charts and sticky elements
            }, 200);

            $this.menuButtonClick = true;

            e.preventDefault();
        });

        this.menuitemLinks.off('click.menu').on('click.menu', function(e) {
            var link = $(this);
            var menuitem = link.parent();
            var submenu = menuitem.children('ul');
            var animate = !(menuitem.hasClass('layout-root-menuitem') && $this.isSlim());

            if (menuitem.hasClass('active-menuitem')) {
                $this.deactivate(menuitem, animate);
            }
            else {
                $this.deactivates(menuitem, animate);
                $this.activate(menuitem, animate);

                var storage = $this.getStorage();
                if (storage) {
                    storage.setItem($this.cfg.stateKey, JSON.stringify(link.attr('href') + ',' + $this.menu.scrollTop()));
                }
            }

            if (submenu.length) {
                e.preventDefault();
            }
        });

        this.rootMenuitems.off('mouseenter.menu').on('mouseenter.menu', function(e) {   
            if ($this.menuActive && $this.isHoverStateActive()) {
                var menuitem = $(this);
                
                if (!menuitem.hasClass('active-menuitem')) {
                    $this.deactivates(menuitem, false);
                    $this.activate(menuitem, false);
                }
            }
        });

        $(document.body).off('click.menu').on('click.menu', function(e) {
            if (!$this.menuClick && $this.isHoverStateActive()) {
                $this.deactivates(undefined, false);
            }

            if (!$this.menuWrapperClick && !$this.menuButtonClick && !($this.isStatic() && $this.isDesktop())) {
                $this.isDesktop() && $this.wrapper.hasClass('layout-menu-active') && $this.wrapper.removeClass('layout-menu-active');
                $this.isMobile() && $this.wrapper.hasClass('layout-menu-mobile-active') && $this.wrapper.removeClass('layout-menu-mobile-active');
            }

            $this.menuClick = false;
            $this.menuButtonClick = false;
            $this.menuWrapperClick = false;
        });
    },

    toggleMenuActive: function() {
        if (this.isDesktop()) {
            this.wrapper.toggleClass('layout-menu-active');
        }
        else {
            if (this.wrapper.hasClass('layout-menu-mobile-active')) {
                this.wrapper.removeClass('layout-menu-mobile-active');
                this.disableModal();
            }
            else {
                this.wrapper.addClass('layout-menu-mobile-active');
                this.enableModal();
            }
        }
    },

    enableModal: function() {
        if (!this.modal) {
            this.modal = $('<div class="layout-modal modal-in"></div>');
            this.wrapper.append(this.modal);
        }
    },
    
    disableModal: function() {
        if (this.modal) {
            this.modal.remove();
            this.modal = null;
        }
    },

    activate: function(menuitem, animate) {
        menuitem.addClass('active-menuitem');

        if (menuitem.hasClass('layout-root-menuitem')) {
            this.menuActive = true;
        }

        var submenu = menuitem.children('ul');
        if (submenu.length) {
            animate ? submenu.slideDown() : submenu.show();
        }
    },
    
    deactivate: function(menuitem, animate) {
        menuitem.removeClass('active-menuitem').find('.ink').remove();

        if (menuitem.hasClass('layout-root-menuitem')) {
            this.menuActive = false;
        }

        var submenu = menuitem.children('ul');
        if (submenu.length) {
            animate ? submenu.slideUp(function() { submenu.css('display', '') }) : (submenu.hide(), submenu.css('display', ''));
        }
    },

    deactivates: function(menuitem, animate) {
        var $this = this;
        var activeMenuitems = this.menuitems.filter('.active-menuitem');

        activeMenuitems.each(function() {
            var item = $(this);

            if (!item.is(menuitem) && !item.has(menuitem).length) {
                $this.deactivate(item, animate);
            }
        });
    },

    restoreMenuState: function() {
        var $this = this;

        if (this.stateful) {
            var link = this.menu.find('a[href^="' + this.cfg.pathname + '"]');

            if (link.length) {
                var menuitem = link.closest('li');
                var parentMenu = menuitem.closest('ul');
                
                menuitem.addClass('active-menuitem');
                link.addClass('active-menuitem-routerlink');

                if (parentMenu.length) {
                    var parentMenuItem = parentMenu.closest('li');

                    while (!parentMenuItem.hasClass('layout-root-menuitem')) {
                        this.activate(parentMenuItem, false);

                        parentMenu = parentMenuItem.closest('ul');
                        if (!parentMenu.length) {
                            break;
                        }

                        parentMenuItem = parentMenu.closest('li');
                    }

                    if (parentMenuItem.hasClass('layout-root-menuitem') && !parentMenuItem.closest('ul').hasClass('layout-menu')) {
                        this.activate(parentMenuItem, false);
                    }
                }

                setTimeout(function() {
                    $this.restoreScrollState(menuitem);
                }, 100);
            }
        }

        if (this.isStatic() && !this.isMobile()) {
            this.menuWrapper.css('transition', 'none');
            this.menuButton.children().css('transition', 'none');
            this.wrapper.addClass('layout-menu-active');

            setTimeout(function() {
                $this.menuWrapper.css('transition', '');
                $this.menuButton.children().css('transition', '');
            }, 100);
        }
    },

    restoreScrollState: function(menuitem) {
        var storage = this.getStorage();
        var stateString = storage.getItem(this.cfg.stateKey);

        if (stateString) {
            var state = JSON.parse(stateString).split(',');

            if (state[0].startsWith(this.cfg.pathname) || this.isScrolledIntoView(menuitem, state[1])) {
                this.menu.scrollTop(parseInt(state[1], 10));
            }
            else {
                this.scrollIntoView(menuitem.get(0));
                storage.removeItem(this.cfg.stateKey);
            }
        }
        else if (!this.isScrolledIntoView(menuitem, menuitem.scrollTop())){
            this.scrollIntoView(menuitem.get(0));
        }
    },

    scrollIntoView: function(element) {
        if (document.documentElement.scrollIntoView) {
            element.scrollIntoView({ block: 'nearest', inline: 'start' });

            var scrollTop = this.menu.scrollTop();
            if (scrollTop > 0) {
                this.menu.scrollTop(scrollTop + parseFloat($('.layout-topbar').height()));
            }
        }
    },

    isScrolledIntoView: function(element, scrollTop) {
        var viewBottom = parseInt(scrollTop, 10) + this.menu.height();

        var top = element.position().top;
        var bottom = top + element.height();

        return ((bottom <= viewBottom) && (top >= scrollTop));
    },

    clearState: function() {
        var storage = this.getStorage();
        storage.removeItem(this.cfg.stateKey);
    },

    getStorage: function() {
        switch (this.cfg.stateStorage) {
            case 'local':
                return window.localStorage;

            case 'session':
                return window.sessionStorage;

            case 'none':
                return null;

            default:
                throw new Error(props.stateStorage + ' is not a valid value for the state storage, supported values are "local", "session" and "custom".');
        }
    },

    getCSSVariable(name) {
        return getComputedStyle(document.body).getPropertyValue(name);
    },

    isDesktop: function() {
        return window.innerWidth > this.mobileBreakpoint;
    },

    isMobile: function() {
        return window.innerWidth <= this.mobileBreakpoint;
    },

    isOverlay: function() {
        return this.wrapper.hasClass('layout-menu-overlay');
    },

    isStatic: function() {
        return this.wrapper.hasClass('layout-menu-static');
    },

    isHorizontal: function() {
        return this.wrapper.hasClass('layout-menu-horizontal');
    },

    isSlim: function() {
        return this.wrapper.hasClass('layout-menu-slim');
    },

    isStateful: function() {
        return this.cfg.stateStorage !== 'none';
    },

    isHoverStateActive: function() {
        return (this.isHorizontal() || this.isSlim()) && this.isDesktop();
    }
});