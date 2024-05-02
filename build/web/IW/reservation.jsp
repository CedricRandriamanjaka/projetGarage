<%@include file="IWheader.jsp" %>

<%@page import="Model.Vehicul"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">nouvele reservation</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Reservation / Nouvel reservation</li>
                    </ol>

                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    Reservation
                                </div>

                                <div class="card-body">
                                    <% if(request.getParameter("ERROR")!=null){ %>
                                        <div class="card bg-danger text-white mb-4">
                                            <div class="card-footer d-flex align-items-center justify-content-between">
                                                <% out.print(request.getParameter("ERROR")); %>
                                            </div>
                                        </div>
                                    <% } %>
                                    <form action="IWReservation" method="post">
                                        <label>voiture a pour le jour</label>
                                        <select name="idvehicul" class="form-control">
                                            <%
                                                ArrayList<Vehicul> listVehicul = (ArrayList<Vehicul>)session.getAttribute("listVehiculClient");
                                                for(int i=0;i<listVehicul.size();i++){ 
                                                    Vehicul v = listVehicul.get(i);
                                                %>
                                                <option value="<% out.print(v.getId()); %>"><% out.print(v.getModelvehicul()); %></option>
                                                <% }
                                            %>
                                        </select>
                                        <a href="ajout.jsp">ajouter une voiture</a><br>
                                        
                                        <label>date pour reservation</label>
                                        <input type="date" name="date" class="form-control">
                                        
                                        <label for="">heure pour reservation</label>
                                        <select name="time"  class="form-control" value="8">
                                            <% for(int i=0;i<24;i++){ %>
                                            <option value="<% out.print(i); %>"><% out.print(i); %></option>
                                            <% }
                                        %>
                                        </select>

                                        <label for="">duree</label>
                                        <input type="number" name="duree"  class="form-control" value="1"><br>

                                        <input type="submit" value="reserver" class="btn btn-primary">
                                    </form>
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
