/**
 * Layout Helpers
 */
var PrimeFacesLayout = {
    styleClass: function(el) {
        var props = PrimeFacesLayout.utils.getProps(el, 'pStyleclass');

        return {
            init: function() {
                if (el) {
                    el['styleclass-initialized'] = true;

                    this.bindEvents();
                }

                return this;
            },

            run: function() {
                this.target = this.resolveTarget();
    
                if (props.toggleClass) {
                    PrimeFacesLayout.utils.toggleClass(this.target, props.toggleClass);
                    this.toggleDocumentListener(PrimeFacesLayout.utils.isVisible(this.target));
                }
                else {
                    if (this.target.offsetParent === null)
                        this.enter();
                    else
                        this.leave();
                }
            },

            enter: function() {
                var $this = this;
    
                if (props.enterActiveClass) {
                    if (!this.animating) {
                        this.animating = true;

                        if (props.enterActiveClass === 'slidedown') {
                            this.target.style.height = '0px';
                            PrimeFacesLayout.utils.removeClass(this.target, 'hidden');
                            this.target.style.maxHeight = this.target.scrollHeight + 'px';
                            PrimeFacesLayout.utils.addClass(this.target, 'hidden');
                            this.target.style.height = '';
                            this.target.style.overflow = 'hidden';
                        }
    
                        PrimeFacesLayout.utils.addClass(this.target, props.enterActiveClass);
                        if (props.enterClass) {
                            PrimeFacesLayout.utils.removeClass(this.target, props.enterClass);
                        }

                        this.enterListener = function() {
                            PrimeFacesLayout.utils.removeClass($this.target, props.enterActiveClass);
                            if (props.enterToClass) {
                                PrimeFacesLayout.utils.addClass($this.target, props.enterToClass);
                            }
                            $this.target.removeEventListener('animationend', $this.enterListener);
    
                            if (props.enterActiveClass === 'slidedown') {
                                $this.target.style.maxHeight = '';
                                $this.target.style.overflow = '';
                            }
                            $this.animating = false;
                        };
    
                        this.target.addEventListener('animationend', this.enterListener);
                    }
                }
                else {
                    if (props.enterClass) {
                        PrimeFacesLayout.utils.removeClass(this.target, props.enterClass);
                    }
    
                    if (props.enterToClass) {
                        PrimeFacesLayout.utils.addClass(this.target, props.enterToClass);
                    }
                }

                $(this.target).on('click.styleclass', '*[data-p-styleclass-hide*="true"]', function(event) {
                    $this.reset();

                    event.stopPropagation();
                });

                this.toggleDocumentListener(true);
            },
    
            leave: function() {
                var $this = this;
    
                if (props.leaveActiveClass) {
                    if (!this.animating) {
                        this.animating = true;

                        if (props.leaveActiveClass === 'slideup') {
                            this.target.style.overflow = 'hidden';
                        }

                        PrimeFacesLayout.utils.addClass(this.target, props.leaveActiveClass);
                        if (props.leaveClass) {
                            PrimeFacesLayout.utils.removeClass(this.target, props.leaveClass);
                        }
    
                        this.leaveListener = function() {
                            PrimeFacesLayout.utils.removeClass($this.target, props.leaveActiveClass);
                            if (props.leaveToClass) {
                                PrimeFacesLayout.utils.addClass($this.target, props.leaveToClass);
                            }
                            $this.target.removeEventListener('animationend', $this.leaveListener);
                            
                            if (props.leaveActiveClass === 'slideup') {
                                $this.target.style.overflow = '';
                            }
                            $this.animating = false;
                        };
    
                        this.target.addEventListener('animationend', this.leaveListener);
                    }
                }
                else {
                    if (props.leaveClass) {
                        PrimeFacesLayout.utils.removeClass(this.target, props.leaveClass);
                    }
    
                    if (props.leaveToClass) {
                        PrimeFacesLayout.utils.addClass(this.target, props.leaveToClass);
                    }
                }
            
                $(this.target).off('click.styleclass', '*[data-p-styleclass-hide*="true"]');
                this.toggleDocumentListener(false);
            },

            reset: function() {
                if (this.target) {
                    if (props.toggleClass)
                        PrimeFacesLayout.utils.toggleClass(this.target, props.toggleClass);
                    else
                        this.leave();

                    this.toggleDocumentListener(false);
                }
            },
    
            resolveTarget: function() {
                if (this.target) {
                    return this.target;
                }
    
                switch (props.selector) {
                    case '@next':
                        return el.nextElementSibling;
    
                    case '@prev':
                        return el.previousElementSibling;
    
                    case '@parent':
                        return el.parentElement;
    
                    case '@grandparent':
                        return el.parentElement.parentElement;
    
                    default:
                        return document.querySelector(props.selector);
                }
            },

            toggleDocumentListener: function(when) {
                if (props.hideOnOutsideClick) {
                    if (when)
                        this.bindDocumentListener();
                    else
                        this.unbindDocumentListener();
                }
            },
    
            bindDocumentListener: function() {
                if (!this.documentListener) {
                    var $this = this;
    
                    this.documentListener = function(event) {
                        if (!el.isSameNode(event.target) && !el.contains(event.target) && !$this.target.contains(event.target)) {
                            $this.reset();
                        }
                    };
    
                    el.ownerDocument.addEventListener('click', this.documentListener);
                }
            },
    
            unbindDocumentListener: function() {
                if (this.documentListener) {
                    el.ownerDocument.removeEventListener('click', this.documentListener);
                    this.documentListener = null;
                }
            },
    
            bindEvents: function() {
                var $this = this;
                this.eventListener = function() {
                    $this.run();
                }
    
                if (el.dataset.pStyleclassEvent === 'hover') {
                    el.addEventListener('mouseenter', this.eventListener);
                    el.addEventListener('mouseleave', this.eventListener);
                }
                else {
                    el.addEventListener('click', this.eventListener);
                }
            }
        }
    },
    utils: {
        getProps: function(el, dataName) {
            if (el && el.dataset[dataName]) {
                var data = el.dataset[dataName].replace(/(['"])?([a-z0-9A-Z_]+)(['"])?:/g, '"$2": ').replaceAll('\'', '"');
                var props = JSON.parse(data) || {};
        
                return props;
            }

            return {};
        },

        addClass: function(element, className) {
            $(element).addClass(className);
        },

        removeClass: function(element, className) {
            $(element).removeClass(className);
        },

        toggleClass: function(element, className) {
            return $(element).toggleClass(className);
        },

        hasClass: function(element, className) {
            return $(element).hasClass(className);
        },

        isVisible: function(element) {
            return element && (element.clientHeight !== 0 || element.getClientRects().length !== 0 || getComputedStyle(element).display !== 'none');
        }
    }
}

$(function() {
    /* StyleClass */
    /** For click event */
    $(document.body).off('click.styleclass', '*[data-p-styleclass]').on('click.styleclass', '*[data-p-styleclass]', function() {
        if (!this['styleclass-initialized']) {
            PrimeFacesLayout.styleClass(this).init().run();
        }
    });

    /** For hover event */
    $(document.body).off('mouseenter.styleclass', '*[data-p-styleclass][data-p-styleclass-event="hover"]').on('mouseenter.styleclass', '*[data-p-styleclass][data-p-styleclass-event="hover"]', function() {
        if (!this['styleclass-initialized']) {
            PrimeFacesLayout.styleClass(this).init();
        }
    });
});

/**
 * Overridden Components of PrimeFaces
 */
if (window['PrimeFaces']) {

    /* Issue #924 is fixed for 5.3+ and 6.0. (compatibility with 5.3) */
    if (PrimeFaces.widget.Dialog) {
        PrimeFaces.widget.Dialog = PrimeFaces.widget.Dialog.extend({

            enableModality: function() {
                this._super();
                $(document.body).children(this.jqId + '_modal').addClass('ui-dialog-mask');
            },

            syncWindowResize: function() {}
        });
    }

    if (PrimeFaces.widget.SelectOneMenu) {
        PrimeFaces.widget.SelectOneMenu = PrimeFaces.widget.SelectOneMenu.extend({
            init: function (cfg) {
                this._super(cfg);

                var $this = this;
                if (this.jq.parent().hasClass('ui-float-label')) {
                    this.m_panel = $(this.jqId + '_panel');
                    this.m_focusInput = $(this.jqId + '_focus');

                    this.m_panel.addClass('ui-input-overlay-panel');
                    this.jq.addClass('ui-inputwrapper');

                    if (this.input.val() != '') {
                        this.jq.addClass('ui-inputwrapper-filled');
                    }

                    this.input.off('change').on('change', function () {
                        $this.inputValueControl($(this));
                    });

                    this.m_focusInput.on('focus.ui-selectonemenu', function () {
                        $this.jq.addClass('ui-inputwrapper-focus');
                    })
                        .on('blur.ui-selectonemenu', function () {
                            $this.jq.removeClass('ui-inputwrapper-focus');
                        });

                    if (this.cfg.editable) {
                        this.label.on('input', function (e) {
                            $this.inputValueControl($(this));
                        }).on('focus', function () {
                            $this.jq.addClass('ui-inputwrapper-focus');
                        }).on('blur', function () {
                            $this.jq.removeClass('ui-inputwrapper-focus');
                            $this.inputValueControl($(this));
                        });
                    }
                }
            },

            inputValueControl: function (input) {
                if (input.val() != '')
                    this.jq.addClass('ui-inputwrapper-filled');
                else
                    this.jq.removeClass('ui-inputwrapper-filled');
            }
        });
    }

    if (PrimeFaces.widget.Chips) {
        PrimeFaces.widget.Chips = PrimeFaces.widget.Chips.extend({
            init: function (cfg) {
                this._super(cfg);

                var $this = this;
                if (this.jq.parent().hasClass('ui-float-label')) {
                    this.jq.addClass('ui-inputwrapper');

                    if ($this.jq.find('.ui-chips-token').length !== 0) {
                        this.jq.addClass('ui-inputwrapper-filled');
                    }

                    this.input.on('focus.ui-chips', function () {
                        $this.jq.addClass('ui-inputwrapper-focus');
                    }).on('input.ui-chips', function () {
                        $this.inputValueControl();
                    }).on('blur.ui-chips', function () {
                        $this.jq.removeClass('ui-inputwrapper-focus');
                        $this.inputValueControl();
                    });

                }
            },

            inputValueControl: function () {
                if (this.jq.find('.ui-chips-token').length !== 0 || this.input.val() != '')
                    this.jq.addClass('ui-inputwrapper-filled');
                else
                    this.jq.removeClass('ui-inputwrapper-filled');
            }
        });
    }

    if (PrimeFaces.widget.DatePicker) {
        PrimeFaces.widget.DatePicker = PrimeFaces.widget.DatePicker.extend({
            init: function (cfg) {
                this._super(cfg);

                var $this = this;
                if (this.jq.parent().hasClass('ui-float-label') && !this.cfg.inline) {
                    if (this.input.val() != '') {
                        this.jq.addClass('ui-inputwrapper-filled');
                    }

                    this.jqEl.off('focus.ui-datepicker blur.ui-datepicker change.ui-datepicker')
                        .on('focus.ui-datepicker', function () {
                            $this.jq.addClass('ui-inputwrapper-focus');
                        })
                        .on('blur.ui-datepicker', function () {
                            $this.jq.removeClass('ui-inputwrapper-focus');
                        })
                        .on('change.ui-datepicker', function () {
                            $this.inputValueControl($(this));
                        });
                }
            },

            inputValueControl: function (input) {
                if (input.val() != '')
                    this.jq.addClass('ui-inputwrapper-filled');
                else
                    this.jq.removeClass('ui-inputwrapper-filled');
            }
        });
    }
}