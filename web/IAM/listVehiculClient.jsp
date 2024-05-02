<%@page import="Model.Vehicul" %>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Client" %>
<% ArrayList<Vehicul> listVehicul = (ArrayList<Vehicul>)session.getAttribute("listVehiculClient"); %>
<% Client client=(Client)session.getAttribute("client"); %>

<%@include file="IAMheader.jsp" %>

              <div id="layoutSidenav_content">
                <main>
                  <div class="container-fluid px-4">
                    <h1 class="mt-4">Bienvenue</h1>
                    <ol class="breadcrumb mb-4">
                      <label for="">liste de de vehicul du client : <% out.print(client.getNameclient()); %></label>

                    </ol>

                    <div class="card mb-4">
                      <div class="card-header">
                        list vehicul
                      </div>

                      <div class="card-body">
                        <table class="table table-striped">
                          <tr>
                            <th>
                              id voiture
                            </th>
                            <th>
                              id client
                            </th>
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
                            <th>
                              longueur
                            </th>
                            <th>
                              largeur
                            </th>
                            <th>
                              hauteur
                            </th>
                            <th>
                              poid
                            </th>
                          </tr>

                          <% for(int i=0;i<listVehicul.size();i++){ %>
                            <tr>
                              <td>
                                <% out.println(listVehicul.get(i).getId()); %>
                              </td>
                              <td>
                                <% out.println(listVehicul.get(i).getIdclient()); %>
                              </td>
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
                              <td>
                                <% out.println(listVehicul.get(i).getLongvehicul()); %>
                              </td>
                              <td>
                                <% out.println(listVehicul.get(i).getLargvehicul()); %>
                              </td>
                              <td>
                                <% out.println(listVehicul.get(i).getHautvehicul()); %>
                              </td>
                              <td>
                                <% out.println(listVehicul.get(i).getPoidvehicul()); %>
                              </td>
                            </tr>
                            <% } %>

                        </table>
                      </div>
                    </div>
                  </div>
                </main>
                <%@include file="../CSS/footer.jsp" %>
              </div>
              </div>
              </body>