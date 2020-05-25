<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html lang="en">

<head>
  <link rel="apple-touch-icon" sizes="76x76" href="<%=request.getContextPath()%>/restrict/assets//img/apple-icon.png">
  <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/restrict/assets//img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
    Biblioteca
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="<%=request.getContextPath()%>/restrict/assets//css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="<%=request.getContextPath()%>/restrict/assets//demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="<%=request.getContextPath()%>/restrict/assets//img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo"><a href="http://www.creative-tim.com" class="simple-text logo-normal">
          Biblioteca
        </a></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item   ">
            <a class="nav-link" href="<%=request.getContextPath()%>/restrict/controllerServlet?controle=BookAction&operacao=exibirPaginaPrincipal">
              <i class="material-icons">dashboard</i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item ">
            <a class="nav-link" href="<%=request.getContextPath()%>/restrict/controllerServlet?controle=UsuarioAction&operacao=listar">
              <i class="material-icons">person</i>
              <p>Usuários</p>
            </a>
          </li>
               
          <li class="nav-item active">
            <a class="nav-link" href="<%=request.getContextPath()%>/restrict/controllerServlet?controle=BookAction&operacao=listar">
              <i class="material-icons">library_books</i>
              <p>Livros</p>
            </a>
          </li>  
          
          <li class="nav-item ">
            <a class="nav-link" href=" <%=request.getContextPath()%>/public/controllerServlet?controle=LoginAction&operacao=sair">
              <i class="material-icons">exit_to_app</i>
              <p>Sair</p>
            </a>
          </li>  
         
             
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:;">
			Cadastro de Livros
			</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <form class="navbar-form">
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <button type="submit" class="btn btn-white btn-round btn-just-icon">
                  <i class="material-icons">search</i>
                  <div class="ripple-container"></div>
                </button>
              </div>
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="javascript:;">
                  <i class="material-icons">dashboard</i>
                  <p class="d-lg-none d-md-block">
                    Stats
                  </p>
                </a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">notifications</i>
                  <span class="notification">5</span>
                  <p class="d-lg-none d-md-block">
                    Some Actions
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                  <a class="dropdown-item" href="#">Mike John responded to your email</a>
                  <a class="dropdown-item" href="#">You have 5 new tasks</a>
                  <a class="dropdown-item" href="#">You're now friend with Andrew</a>
                  <a class="dropdown-item" href="#">Another Notification</a>
                  <a class="dropdown-item" href="#">Another One</a>
                </div>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                  <a class="dropdown-item" href="#">Profile</a>
                  <a class="dropdown-item" href="#">Settings</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Log out</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">
                  
				<c:choose>
                <c:when test="${not empty book.id}" >
                    <%-- Se existe id é alteração. Quando o id for nulo é cadastro. 
                    Pois, o id só é gerado depois qu eo usuário é incluído no banco --%>
                    Alteração de Livro
                </c:when>
                <c:otherwise>
                    <%-- Se não existe, é um cadastro Quando o id não for nulo é alteração.--%>
                    Cadastro de Livro
                </c:otherwise>
            </c:choose>                   
                  </h4>
                  <p class="card-category">Informe os dados do livro</p>
                </div>
                <div class="card-body">
                  <form action="<%=request.getContextPath()%>/restrict/controllerServlet" 
         				method="post" 
         				accept-charset="utf-8" >	
         							
		            <input type="hidden" name="controle"  value="BookAction"/>	
			    	<input type="hidden" name="id" value="${book.id}" />
                  	
                  	<div class="row">
                  	 <div class="col-md-2">
                        <div class="form-group">
                            <div class="form-control">  
	                            <label class="bmd-label-floating">ID: </label> 
	                            ${book.id} 
                            </div>
                        </div>
                      </div>
                      <div class="col-md-10">
                        <div class="form-group">
                          <label class="bmd-label-floating">Título</label>
                          <input  value="${book.title}" name="title" type="text" class="form-control">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-10">
                        <div class="form-group">
                          <label class="bmd-label-floating">Autor</label>
                          <input value="${book.author}" name="author" type="text" class="form-control">
                        </div>
                      </div>
                      <div class="col-md-2">
                        <div class="form-group">
                          <label class="bmd-label-floating">Ano</label>
                          <input value="${book.ano}" name="ano" type="text" class="form-control">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label>Sumário</label>
                          <div class="form-group">
                            <label class="bmd-label-floating"> Incluir sinopso do livro. Algo legal, que atraia a atenção do leitor...</label>
                            <textarea name="summary" class="form-control"  rows="5"></textarea>
                          </div>
                        </div>
                      </div>
                    </div>
					<c:choose>
		                 <c:when test="${not empty book.id}" >
			                   <input type="hidden" name="operacao" value="alterar" title="alterar dados" />
			                   <input type="submit" value="Alterar" class="btn btn-primary pull-right" />
		                </c:when> 
		                
		                 <c:otherwise>
			 					<input type="hidden" name="operacao" value="cadastrar" title="salvar n obanco de dados"/>			      
			                    <input type="submit" value="Cadastrar" class="btn btn-primary pull-right"  />
		                </c:otherwise>
		            </c:choose>        
		               
		            
		            <input type="reset" value="Desfazer" title="Desfazer alterações realizadas" class="btn btn-outline-danger" />
		            
		            <a href="<%=request.getContextPath()%>/restrict/controllerServlet?controle=BookAction&operacao=listar">
		                <input type="button" value="Cancelar e voltar" class="btn btn-outline-danger" >
		            </a>   
                    <div class="clearfix"></div>
                    
                  </form>
                </div>
              </div>
            </div>
<!--             <div class="col-md-4"> -->
<!--               <div class="card card-profile"> -->
<!--                 <div class="card-avatar"> -->
<!--                   <a href="javascript:;"> -->
<%--                     <img class="img" src="<%=request.getContextPath()%>/restrict/assets//img/faces/marc.jpg" /> --%>
<!--                   </a> -->
<!--                 </div> -->
<!--                 <div class="card-body"> -->
<!--                   <h6 class="card-category text-gray">CEO / Co-Founder</h6> -->
<!--                   <h4 class="card-title">Alec Thompson</h4> -->
<!--                   <p class="card-description"> -->
<!--                     Don't be scared of the truth because we need to restart the human foundation in truth And I love you like Kanye loves Kanye I love Rick Owensâ€™ bed design but the back is... -->
<!--                   </p> -->
<!--                   <a href="javascript:;" class="btn btn-primary btn-round">Follow</a> -->
<!--                 </div> -->
<!--               </div> -->
<!--             </div> -->
          </div>
        </div>
      </div>
      <footer class="footer">
        <div class="container-fluid">
          <nav class="float-left">
            <ul>
              <li>
                <a href="https://www.creative-tim.com">
                  Creative Tim
                </a>
              </li>
              <li>
                <a href="https://creative-tim.com/presentation">
                  About Us
                </a>
              </li>
              <li>
                <a href="http://blog.creative-tim.com">
                  Blog
                </a>
              </li>
              <li>
                <a href="https://www.creative-tim.com/license">
                  Licenses
                </a>
              </li>
            </ul>
          </nav>
          <div class="copyright float-right">
            &copy;
            <script>
              document.write(new Date().getFullYear())
            </script>, made with <i class="material-icons">favorite</i> by
            <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a> for a better web.
          </div>
        </div>
      </footer>
    </div>
  </div>
<!--   <div class="fixed-plugin"> -->
<!--     <div class="dropdown show-dropdown"> -->
<!--       <a href="#" data-toggle="dropdown"> -->
<!--         <i class="fa fa-cog fa-2x"> </i> -->
<!--       </a> -->
<!--       <ul class="dropdown-menu"> -->
<!--         <li class="header-title"> Sidebar Filters</li> -->
<!--         <li class="adjustments-line"> -->
<!--           <a href="javascript:void(0)" class="switch-trigger active-color"> -->
<!--             <div class="badge-colors ml-auto mr-auto"> -->
<!--               <span class="badge filter badge-purple" data-color="purple"></span> -->
<!--               <span class="badge filter badge-azure" data-color="azure"></span> -->
<!--               <span class="badge filter badge-green" data-color="green"></span> -->
<!--               <span class="badge filter badge-warning" data-color="orange"></span> -->
<!--               <span class="badge filter badge-danger" data-color="danger"></span> -->
<!--               <span class="badge filter badge-rose active" data-color="rose"></span> -->
<!--             </div> -->
<!--             <div class="clearfix"></div> -->
<!--           </a> -->
<!--         </li> -->
<!--         <li class="header-title">Images</li> -->
<!--         <li class="active"> -->
<!--           <a class="img-holder switch-trigger" href="javascript:void(0)"> -->
<%--             <img src="<%=request.getContextPath()%>/restrict/assets//img/sidebar-1.jpg" alt=""> --%>
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a class="img-holder switch-trigger" href="javascript:void(0)"> -->
<%--             <img src="<%=request.getContextPath()%>/restrict/assets//img/sidebar-2.jpg" alt=""> --%>
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a class="img-holder switch-trigger" href="javascript:void(0)"> -->
<%--             <img src="<%=request.getContextPath()%>/restrict/assets//img/sidebar-3.jpg" alt=""> --%>
<!--           </a> -->
<!--         </li> -->
<!--         <li> -->
<!--           <a class="img-holder switch-trigger" href="javascript:void(0)"> -->
<%--             <img src="<%=request.getContextPath()%>/restrict/assets//img/sidebar-4.jpg" alt=""> --%>
<!--           </a> -->
<!--         </li> -->
<!--         <li class="button-container"> -->
<!--           <a href="https://www.creative-tim.com/product/material-dashboard" target="_blank" class="btn btn-primary btn-block">Free Download</a> -->
<!--         </li> -->
<!--         <li class="header-title">Want more components?</li>
<!--             <li class="button-container"> -->
<!--                 <a href="https://www.creative-tim.com/product/material-dashboard-pro" target="_blank" class="btn btn-warning btn-block"> -->
<!--                   Get the pro version -->
<!--                 </a> -->
<!--             </li> --> -->
<!--         <li class="button-container"> -->
<!--           <a href="https://demos.creative-tim.com/material-dashboard/docs/2.1/getting-started/introduction.html" target="_blank" class="btn btn-default btn-block"> -->
<!--             View Documentation -->
<!--           </a> -->
<!--         </li> -->
<!--         <li class="button-container github-star"> -->
<!--           <a class="github-button" href="https://github.com/creativetimofficial/material-dashboard" data-icon="octicon-star" data-size="large" data-show-count="true" aria-label="Star ntkme/github-buttons on GitHub">Star</a> -->
<!--         </li> -->
<!--         <li class="header-title">Thank you for 95 shares!</li> -->
<!--         <li class="button-container text-center"> -->
<!--           <button id="twitter" class="btn btn-round btn-twitter"><i class="fa fa-twitter"></i> &middot; 45</button> -->
<!--           <button id="facebook" class="btn btn-round btn-facebook"><i class="fa fa-facebook-f"></i> &middot; 50</button> -->
<!--           <br> -->
<!--           <br> -->
<!--         </li> -->
<!--       </ul> -->
<!--     </div> -->
<!--   </div> -->
  <!--   Core JS Files   -->
 
  <script>
    $(document).ready(function() {
      $().ready(function() {
        $sidebar = $('.sidebar');

        $sidebar_img_container = $sidebar.find('.sidebar-background');

        $full_page = $('.full-page');

        $sidebar_responsive = $('body > .navbar-collapse');

        window_width = $(window).width();

        fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();

        if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
          if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
            $('.fixed-plugin .dropdown').addClass('open');
          }

        }

        $('.fixed-plugin a').click(function(event) {
          // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
          if ($(this).hasClass('switch-trigger')) {
            if (event.stopPropagation) {
              event.stopPropagation();
            } else if (window.event) {
              window.event.cancelBubble = true;
            }
          }
        });

        $('.fixed-plugin .active-color span').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-color', new_color);
          }

          if ($full_page.length != 0) {
            $full_page.attr('filter-color', new_color);
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.attr('data-color', new_color);
          }
        });

        $('.fixed-plugin .background-color .badge').click(function() {
          $(this).siblings().removeClass('active');
          $(this).addClass('active');

          var new_color = $(this).data('background-color');

          if ($sidebar.length != 0) {
            $sidebar.attr('data-background-color', new_color);
          }
        });

        $('.fixed-plugin .img-holder').click(function() {
          $full_page_background = $('.full-page-background');

          $(this).parent('li').siblings().removeClass('active');
          $(this).parent('li').addClass('active');


          var new_image = $(this).find("img").attr('src');

          if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            $sidebar_img_container.fadeOut('fast', function() {
              $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
              $sidebar_img_container.fadeIn('fast');
            });
          }

          if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $full_page_background.fadeOut('fast', function() {
              $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
              $full_page_background.fadeIn('fast');
            });
          }

          if ($('.switch-sidebar-image input:checked').length == 0) {
            var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
            var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

            $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
            $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
          }

          if ($sidebar_responsive.length != 0) {
            $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
          }
        });

        $('.switch-sidebar-image input').change(function() {
          $full_page_background = $('.full-page-background');

          $input = $(this);

          if ($input.is(':checked')) {
            if ($sidebar_img_container.length != 0) {
              $sidebar_img_container.fadeIn('fast');
              $sidebar.attr('data-image', '#');
            }

            if ($full_page_background.length != 0) {
              $full_page_background.fadeIn('fast');
              $full_page.attr('data-image', '#');
            }

            background_image = true;
          } else {
            if ($sidebar_img_container.length != 0) {
              $sidebar.removeAttr('data-image');
              $sidebar_img_container.fadeOut('fast');
            }

            if ($full_page_background.length != 0) {
              $full_page.removeAttr('data-image', '#');
              $full_page_background.fadeOut('fast');
            }

            background_image = false;
          }
        });

        $('.switch-sidebar-mini input').change(function() {
          $body = $('body');

          $input = $(this);

          if (md.misc.sidebar_mini_active == true) {
            $('body').removeClass('sidebar-mini');
            md.misc.sidebar_mini_active = false;

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

          } else {

            $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

            setTimeout(function() {
              $('body').addClass('sidebar-mini');

              md.misc.sidebar_mini_active = true;
            }, 300);
          }

          // we simulate the window Resize so the charts will get updated in realtime.
          var simulateWindowResize = setInterval(function() {
            window.dispatchEvent(new Event('resize'));
          }, 180);

          // we stop the simulation of Window Resize after the animations are completed
          setTimeout(function() {
            clearInterval(simulateWindowResize);
          }, 1000);

        });
      });
    });
  </script>
</body>

</html>