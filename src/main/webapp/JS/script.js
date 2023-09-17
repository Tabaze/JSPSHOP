'use strict'


function find(el, selector) {
  let finded
  return (finded = el.querySelector(selector)) ? finded : null
}

function siblings(el) {
  const siblings = []
  for (let sibling of el.parentNode.children) {
    if (sibling !== el) {
      siblings.push(sibling)
    }
  }
  return siblings
}

const showAsideBtn = $('.show-side-btn')
const sidebar = $('.sidebar')
const wrapper = $('#wrapper')

showAsideBtn.on('click', function () {
  $(`#${this.dataset.show}`).toggleClass('show-sidebar')
  wrapper.toggleClass('fullwidth')
})

if (window.innerWidth < 767) {
  sidebar.classList.add('show-sidebar');
}

//window.addEventListener('resize', function () {
//  if (window.innerWidth > 767) {
//    sidebar.classList.remove('show-sidebar')
//  }
//})

// dropdown menu in the side nav
var slideNavDropdown = $('.sidebar-dropdown');

$('.sidebar .categories').on('click', function (event) {
  event.preventDefault()

  const item = event.target.closest('.has-dropdown')

  if (!item) {
    return
  }

  item.classList.toggle('opened')

  siblings(item).forEach(sibling => {
    sibling.classList.remove('opened')
  })

  if (item.classList.contains('opened')) {
    const toOpen = find(item, '.sidebar-dropdown')

    if (toOpen) {
      toOpen.classList.add('active')
    }

    siblings(item).forEach(sibling => {
      const toClose = find(sibling, '.sidebar-dropdown')

      if (toClose) {
        toClose.classList.remove('active')
      }
    })
  } else {
    find(item, '.sidebar-dropdown').classList.toggle('active')
  }
})

$('.sidebar .close-aside').on('click', function () {
  $(`#${this.dataset.close}`).classList.add('show-sidebar')
  wrapper.classList.remove('margin')
})

var Nav = (function () {

  let nav = $('.nav')
  let burger = $('.burger')
  let page = $('.page')
  let section = $('.section')
  console.log(nav)
  let link = nav.find('.nav--link')
  let navH = nav.innerHeight()
  let isOpen = true
  let hasT = false;

  var toggleNav = function () {
    nav.toggleClass('nav--active');
    burger.toggleClass('burger--close');
    shiftPage();
  };

  var shiftPage = function () {
    if (!isOpen) {
      page.css({
        'transform': 'translateY(' + navH + 'px)',
        '-webkit-transform': 'translateY(' + navH + 'px)'
      });
      isOpen = true;
    } else {
      page.css({
        'transform': 'none',
        '-webkit-transform': 'none'
      });
      isOpen = false;
    }
  };

  var switchPage = function (e) {
    var self = $(this);
    var i = self.parents('.nav__item').index();
    var s = section.eq(i);
    var a = $('section.section--active');
    var t = $(e.target);

    if (!hasT) {
      if (i == a.index()) {
        return false;
      }
      a
        .addClass('section--hidden')
        .removeClass('section--active');

      s.addClass('section--active');

      hasT = true;

      a.on('transitionend webkitTransitionend', function () {
        $(this).removeClass('section--hidden');
        hasT = false;
        a.off('transitionend webkitTransitionend');
      });
    }

    return false;
  };

  var keyNav = function (e) {
    var a = $('section.section--active');
    var aNext = a.next();
    var aPrev = a.prev();
    var i = a.index();


    if (!hasT) {
      if (e.keyCode === 37) {

        if (aPrev.length === 0) {
          aPrev = section.last();
        }

        hasT = true;

        aPrev.addClass('section--active');
        a
          .addClass('section--hidden')
          .removeClass('section--active');

        a.on('transitionend webkitTransitionend', function () {
          a.removeClass('section--hidden');
          hasT = false;
          a.off('transitionend webkitTransitionend');
        });

      } else if (e.keyCode === 39) {

        if (aNext.length === 0) {
          aNext = section.eq(0)
        }


        aNext.addClass('section--active');
        a
          .addClass('section--hidden')
          .removeClass('section--active');

        hasT = true;

        aNext.on('transitionend webkitTransitionend', function () {
          a.removeClass('section--hidden');
          hasT = false;
          aNext.off('transitionend webkitTransitionend');
        });

      } else {
        return
      }
    }
  };

  var bindActions = function () {
    burger.on('click', toggleNav);
    link.on('click', switchPage);
    $(document).on('ready', function () {
      page.css({
        'transform': 'translateY(' + navH + 'px)',
        '-webkit-transform': 'translateY(' + navH + 'px)'
      });
    });
    $('body').on('keydown', keyNav);
  };

  var init = function () {
    bindActions();
  };

  return {
    init: init
  };

}());

Nav.init();
const products = document.querySelectorAll(".product");
const container = document.querySelector(".container");
const nav = document.querySelector(".nav");
const cover = document.querySelector(".cover");
const productWidth = 310;
const overlay = document.querySelector(".product__overlay");

function getProductOffset() {
  return (container.offsetWidth - container.offsetWidth * 70 / 100) / 2;
}

function removeActiveClass() {
  const activeProduct = document.querySelector(".product--active");
  if (activeProduct) {
    activeProduct.scrollTop = 0;
    activeProduct.classList.remove("product--active");
    container.classList.remove("container--detail");
  }
}

products.forEach(product => {
  product.addEventListener("click", e => {
    if (e.target.classList.contains("product__close")) {
      overlay.style.display = "none";
      removeActiveClass();
      return;
    }
    if (!e.currentTarget.classList.contains("product--active")) {
      overlay.style.display = "block";
      removeActiveClass();
      e.currentTarget.classList.add("product--active");
      container.classList.add("container--detail");

      const left =
      productWidth * parseInt(e.currentTarget.getAttribute("data-index")) +
      cover.offsetWidth +
      parseInt(e.currentTarget.getAttribute("data-index")) * 6 +
      nav.offsetWidth -
      getProductOffset();

      container.scrollLeft = left;
      overlay.style.display = "none";
      if (
      /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(
      navigator.userAgent))

      {
        e.currentTarget.scrollIntoView({ inline: "start" });
      }
    }
  });
});
(function($){
	function floatLabel(inputType){
		$(inputType).each(function(){
			var $this = $(this);
			// on focus add cladd active to label
			$this.focus(function(){
				$this.next().addClass("active");
			});
			//on blur check field and remove class if needed
			$this.blur(function(){
				if($this.val() === '' || $this.val() === 'blank'){
					$this.next().removeClass();
				}
			});
		});
	}
	// just add a class of "floatLabel to the input field!"
	floatLabel(".floatLabel");
})(jQuery);

