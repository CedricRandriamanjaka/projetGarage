<%@page import="Model.Reservation"%>
<%@include file="IWheader.jsp" %>

<%@page import="Model.Vehicul" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% ArrayList<Reservation> listReservation1 = (ArrayList<Reservation>)session.getAttribute("listReservationTrue"); %>
<% ArrayList<Reservation> listReservation2 = (ArrayList<Reservation>)session.getAttribute("listReservationFalse"); %>

          <div id="layoutSidenav_content">
            <main>
              <div class="container-fluid px-4">
                <h1 class="mt-4">Mes reservation</h1>
                <ol class="breadcrumb mb-4">
                  <li class="breadcrumb-item active">Reservation / Mes reservation</li>
                </ol>

                <div class="card mb-4">
                  <div class="card-header">
                    mes reservation
                  </div>

                  <div class="card-body">
                    <% if(listReservation1.size()==0){ %>
                        <h4>aucune reservation</h4>
                    <% } else { %>
                    <table class="table table-striped">
                        <tr>
                          <th>
                            vahicul
                          </th>
                          <th>
                            slot
                          </th>
                          <th>
                            date
                          </th>
                          <th>
                            heure
                          </th>
                          <th>
                            duree
                          </th>
                          <th>
                            annuler
                          </th>
                        </tr>
                        <% for(int i=0;i<listReservation1.size();i++){ %>
                          <tr>
                            <td>
                              <% out.println(listReservation1.get(i).getIdvehicul()); %>
                            </td>
                            <td>
                              <% out.println(listReservation1.get(i).getIdslot()); %>
                            </td>
                            <td>
                              <% out.println(listReservation1.get(i).getDatereservation()); %>
                            </td>
                            <td>
                              <% out.println(listReservation1.get(i).getHeure()); %>
                            </td>
                            <td>
                              <% out.println(listReservation1.get(i).getDuree()); %>
                            </td>
                            <td>
                              <form action="IWListReservation" method="post">
                                <input type="hidden" name="id" value="<% out.println(listReservation1.get(i).getId()); %>">
                                <button type='submit' class="btn btn-primary" style="background-color: red;border: red;">annuler</button>
                              </form>
                            </td>
                          </tr>
                          <% } %>
                    </table>
                  <% } %>
                  </div>
                </div>
                <div class="card mb-4">
                  <div class="card-header">
                    mes reservation annuler
                  </div>

                  <div class="card-body">
                    <% if(listReservation2.size()==0){ %>
                        <h4>aucune reservation annuler</h4>
                    <% } else { %>
                    <table class="table table-striped">
                        <tr>
                          <th>
                            vahicul
                          </th>
                          <th>
                            slot
                          </th>
                          <th>
                            date
                          </th>
                          <th>
                            heure
                          </th>
                          <th>
                            duree
                          </th>
                        </tr>
                        <% for(int i=0;i<listReservation2.size();i++){ %>
                          <tr>
                            <td>
                              <% out.println(listReservation2.get(i).getIdvehicul()); %>
                            </td>
                            <td>
                              <% out.println(listReservation2.get(i).getIdslot()); %>
                            </td>
                            <td>
                              <% out.println(listReservation2.get(i).getDatereservation()); %>
                            </td>
                            <td>
                              <% out.println(listReservation2.get(i).getHeure()); %>
                            </td>
                            <td>
                              <% out.println(listReservation2.get(i).getDuree()); %>
                            </td>
                          </tr>
                          <% } %>
                    </table>
                    <% } %> 
                  </div>
                </div>
              </div>
            </main>
            <%@include file="../CSS/footer.jsp" %>
          </div>
          </div>
          </body>