<%@include file="../CSS/header.jsp" %>

    <body class="sb-nav-fixed">


        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand ps-3" href="IWAcceuil">Projet Parking</a>

            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="recherche" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="submit">recherche</button>
                </div>
            </form>
        </nav>

        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">

                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Navigation</div>
                            <a class="nav-link" href="IWAcceuil">
                                acceuil
                            </a>

                            <div class="sb-sidenav-menu-heading">vehicule</div>
                            <a class="nav-link" href="ajout.jsp">
                                nouveau vehicule
                            </a>

                            <div class="sb-sidenav-menu-heading">Reservation</div>
                            <a class="nav-link" href="IWReservation">
                                nouvele reservation
                            </a>
                            <a class="nav-link" href="IWListReservation">
                                mes reservation
                            </a>
                            
                            <div class="sb-sidenav-menu-heading"><a href="http://localhost:8080/ProjetParking/IW"><button class="btn btn-primary" style="background-color: red;border: red;">deconnection</button></a></div>
                        </div>
                    </div>
                </nav>
            </div>