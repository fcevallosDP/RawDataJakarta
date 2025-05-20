/**
 * Layout Config
 */
PrimeFaces.LayoutConfigurator = {

    changeLayoutMode: function(color, menuTheme, topbarTheme, componentTheme, callback) {
        var linkElement = $('link[href*="layout-"]');
        var href = linkElement.attr('href');
        var startIndexOf = href.indexOf('layout-') + 7;
        var endIndexOf = href.indexOf('.css');
        var currentColor = href.substring(startIndexOf, endIndexOf);

        this.replaceLink(linkElement, href.replace(currentColor, color), callback);

        if (color === 'dark') {
            this.changeMenuTheme(menuTheme, 'dark');
            this.changeTopbarTheme(topbarTheme, 'dark');
            this.changeComponentTheme(componentTheme, true);
        }
        else {
            this.changeMenuTheme(menuTheme, 'light');
            this.changeTopbarTheme(topbarTheme, 'blue');
            this.changeComponentTheme(componentTheme);
        }
    },

    changeComponentTheme: function(theme, mode) {
        var library = 'primefaces-ultima';
        var linkElement = $('link[href*="theme.css"]');
        var href = linkElement.attr('href');
        var index = href.indexOf(library) + 1;
        var currentTheme = href.substring(index + library.length);
        this.replaceLink(linkElement, href.replace(currentTheme, theme + (mode ? '-dark' : '')));
    },

    changeTopbarTheme: function(oldTheme, newTheme) {
        $('.layout-wrapper').removeClass('layout-topbar-' + oldTheme.toLowerCase()).addClass('layout-topbar-' + newTheme.toLowerCase());
    },

    changeMenuTheme: function(oldTheme, newTheme) {
        $('.layout-wrapper').removeClass('layout-menu-' + oldTheme.toLowerCase()).addClass('layout-menu-' + newTheme.toLowerCase());
    },

    changeMenuMode: function(oldMode, newMode) {
        $('.layout-wrapper').removeClass('layout-menu-' + oldMode.toLowerCase()).addClass('layout-menu-' + newMode.toLowerCase());
        this.clearMenuState();
    },

    changeInputStyle: function(oldStyle, newStyle) {
        $(document.body).removeClass('ui-input-' + oldStyle.toLowerCase()).addClass('ui-input-' + newStyle.toLowerCase());
    },

    toggleRTL: function(rtl) {
        $('.layout-wrapper').toggleClass('layout-rtl');
    },

    clearMenuState: function() {
        var menu = PF('layoutMenuWidget');

        if (menu) {
            menu.clearState();
        }
    },

    beforeResourceChange: function() {
        PrimeFaces.ajax.RESOURCE = null;    //prevent resource append
    },
    
    replaceLink: function(linkElement, href, callback) {
        PrimeFaces.ajax.RESOURCE = 'javax.faces.Resource';
        clearTimeout(this.callbackTimeout);

        var $this = this;
        var isIE = this.isIE();

        if (isIE) {
            linkElement.attr('href', href);
            $this.callbackTimeout = setTimeout(function() {
                callback && callback();
            }, 100);
        }
        else {
            var cloneLinkElement = linkElement.clone(false);

            cloneLinkElement.attr('href', href);
            linkElement.after(cloneLinkElement);
            
            cloneLinkElement.off('load').on('load', function() {
                linkElement.remove();
                $this.callbackTimeout = setTimeout(function() {
                    callback && callback();
                }, 100);
            });
        }
    },

    isIE: function() {
        return /(MSIE|Trident\/|Edge\/)/i.test(navigator.userAgent);
    }
};