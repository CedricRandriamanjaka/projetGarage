<%@page import="Model.Slot"%>
<%@page import="Model.Reservation"%>
<%@page import="Model.Vehicul"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Reservation res =(Reservation) session.getAttribute("ReservationValide"); %>
<% Slot slot =(Slot) session.getAttribute("SlotValide"); %>






<%@include file="IWheader.jsp" %>


        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4"></h1>

                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    Facture
                                </div>

                                <div class="card-body">
                                        <h1>reservation valider</h1>
                                        <h4>slot : <% out.print(slot.getNameslot()); %></h4>
                                        <h4>date : <% out.print(res.getDatereservation()); %></h4>
                                        <h4>heure : <% out.print(res.getHeure()); %></h4>
                                        <h4>durre : <% out.print(res.getDuree()); %></h4>
                                        <a href="acceuil.jsp">acceuil</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>            
            <%@include file="../CSS/footer.jsp" %>
        </div>
    </div>
    </body>