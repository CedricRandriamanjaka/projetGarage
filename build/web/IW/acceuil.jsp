<%@include file="IWheader.jsp" %>

  <%@page import="Model.Vehicul" %>
    <%@page import="java.util.ArrayList" %>
      <%@page import="java.util.ArrayList" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>

          <div id="layoutSidenav_content">
            <main>
              <div class="container-fluid px-4">
                <h1 class="mt-4">Bienvenue</h1>
                <ol class="breadcrumb mb-4">
                  <li class="breadcrumb-item active">acceuil</li>
                </ol>

                <div class="row">
                  <div class="col-xl-6">
                    <div class="card mb-4">
                      <div class="card-header">
                        Reservation
                      </div>

                      <div class="card-body">
                            <form action="IWReservation" method="post">
                              <label>voiture a pour le jour</label>
                              <select name="idvehicul" class="form-control">
                                <% ArrayList<Vehicul> listVehicul = (ArrayList<Vehicul>
                                    )session.getAttribute("listVehiculClient");
                                    for(int i=0;i<listVehicul.size();i++){ Vehicul v=listVehicul.get(i); %>
                                      <option value="<% out.print(v.getId()); %>">
                                        <% out.print(v.getModelvehicul()); %>
                                      </option>
                                      <% } %>
                              </select>
                              <a href="ajout.jsp">ajouter une voiture</a><br>

                              <label>date pour reservation</label>
                              <input required type="date" name="date" class="form-control" >

                              <label for="">heure pour reservation</label>
                              <select name="time" class="form-control" value="8">
                                <% for(int i=0;i<24;i++){ %>
                                  <option value="<% out.print(i); %>">
                                    <% out.print(i); %>
                                  </option>
                                  <% } %>
                              </select>

                              <label for="">duree</label>
                              <select name="duree" class="form-control" value="1">
                                <% for(int i=1;i<24;i++){ %>
                                  <option value="<% out.print(i); %>">
                                    <% out.print(i); %>
                                  </option>
                                <% } %>
                              </select><br>
                              <input type="submit" value="reserver" class="btn btn-primary">
                            </form>
                            <hr>
                            <h4>mes Vehicul</h4>
                            <div>
                                <div class="card-header">
                                    mes voitures
                                </div>

                  <div class="card-body">
                    <table class="table table-striped">
                        <tr>
                          <th>
                            type
                          </th>
                          <th>
                            marque
                          </th>
                          <th>
                            model
                          </th>
                          <th>
                            couleur
                          </th>
                          <th>
                            matriculation
                          </th>
                        </tr>
                        <% for(int i=0;i<listVehicul.size();i++){ %>
                          <tr>
                            <td>
                              <% out.println(listVehicul.get(i).getTypevehicul()); %>
                            </td>
                            <td>
                              <% out.println(listVehicul.get(i).getMarquevehicul()); %>
                            </td>
                            <td>
                              <% out.println(listVehicul.get(i).getModelvehicul()); %>
                            </td>
                            <td>
                              <% out.println(listVehicul.get(i).getColorvehicul()); %>
                            </td>
                            <td>
                              <% out.println(listVehicul.get(i).getMatriculationvahicul()); %>
                            </td>
                          </tr>
                          <% } %>
                    </table>
                  </div>
                            </div>
                            
                      </div>
                    </div>
                  </div>

                  <div class="col-xl-6">
                    <div class="card mb-4">
                      <div class="card-header">
                        nouveau vehicul
                      </div>

                      <div class="card-body">
                        <form action="IWAjoutClient" method="post">
                          <label for="">type de vehicul</label>
                          <select name="typevehicul" class="form-control">
                            <option value="classique">voiture classique</option>
                            <option value="moto">moto</option>
                            <option value="camion">camion</option>
                            <option value="autre">camion</option>
                          </select>

                          <label for="">marque</label>
                          <input type="text" name="marquevehicul" class="form-control" required>

                          <label for="">model</label>
                          <input type="text" name="modelvehicul" class="form-control" required>

                          <label for="">color</label>
                          <select name="colorvehicul" class="form-control">
                            <option value="noir">noir</option>
                            <option value="blanc">blanc</option>
                            <option value="rouge">rouge</option>
                            <option value="bleu">bleu</option>
                          </select>

                          <label for="">matriculation</label>
                          <input type="text" name="matriculationvehicul" class="form-control" required>
                          
                          <br>
                          <h4>dimention du vehicul</h4>

                          <label for="">longueur</label>
                          <input type="number" name="longvehicul" class="form-control" placeholder="en centimetre" required>

                          <label for="">largueur</label>
                          <input type="number" name="largvehicul" class="form-control" placeholder="en centimetre" required>

                          <label for="">heuteur</label>
                          <input type="number" name="hautvehicul" class="form-control" placeholder="en centimetre" required>

                          <label for="">poid</label>
                          <input type="numer" name="poidvehicul" class="form-control" placeholder="en kg" required>
                          
                          <br>
                          <input type="submit" value="enregistre" class="btn btn-primary">
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