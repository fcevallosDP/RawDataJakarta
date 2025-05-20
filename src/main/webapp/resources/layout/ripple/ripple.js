$(function() {
    var ripple = {
        selectors: [
            '[data-p-ripple="true"]',
            '.ui-ripple',
            '.ui-button',
            '.ui-selectlistbox-item',
            '.ui-multiselectlistbox-item',
            '.ui-tabs-header',
            '.ui-fieldset-toggler',
            '.fc-button-primary'
        ],
        disabledSelectors: [
            '.ui-ripple-disabled'
        ],
        getSelector: function() {
            var _selectors = [];
            var disabledSelector = ':not(' + ripple.disabledSelectors.join(',') + ')';

            for (var i = 0; i < ripple.selectors.length; i++) {
                _selectors.push(disabledSelector + ' ' + ripple.selectors[i]);
            }

            return _selectors.join(',');
        }
    };

    var selector = ripple.getSelector();
    $(document.body).off('mousedown.ripple animationend.ripple animationcancel.ripple', selector)
        .on('mousedown.ripple', selector, null, function(e) {
            var element = $(this);

            if (element.find('.ink').length === 0) {
                element.append("<span class='ink'></span>");
            }

            var ink = element.find('.ink');
            if (!ink.height() && !ink.width()) {
                var d = Math.max(element.outerWidth(), element.outerHeight());
                ink.css({ height: d, width: d });
            }

            var x = e.pageX - element.offset().left - (ink.width() / 2);
            var y = e.pageY - element.offset().top - (ink.height() / 2);
            
            element.addClass('ui-ripple');
            if (element.css('position') === 'static') {
                element.addClass('ui-ripple-boundary');
            }

            ink.css({ top: y + 'px', left: x + 'px', 'pointer-events': 'none' }).addClass('ripple-animate');
        })
        .on('animationend.ripple animationcancel.ripple', selector, null, function(e) {
            if (e.originalEvent.animationName === 'ripple') {
                $(this).find('.ink').remove();
            }
        });
});