<%@page import="Model.Vehicul" %>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Client" %>
<% ArrayList<Client> listClient = (ArrayList<Client>)session.getAttribute("listClient"); %>
<% ArrayList<Vehicul> listVehicul = (ArrayList<Vehicul>)session.getAttribute("listVehicul"); %>
<% ArrayList<Client> listClientNom = (ArrayList<Client>)session.getAttribute("listClientNom"); %>

<%@include file="IAMheader.jsp" %>

    <div id="layoutSidenav_content">
      <main>
        <div class="container-fluid px-4">
          <h1 class="mt-4">Nos Client</h1>
          <ol class="breadcrumb mb-4">
            <li>la liste officiel de nos clients</li>
          </ol>

          <div class="card mb-4">
            <div class="card-header">
              client actif
            </div>

            <div class="card-body">
              <table class="table table-striped">
                <tr>
                  <th>
                    id
                  </th>
                  <th>
                    nom
                  </th>
                  <th>
                    voir leurs voitures
                  </th>
                </tr>
                <% for(int i=0;i<listClient.size();i++){ %>
                <tr>
                  <td>
                    <% out.println(listClient.get(i).getId()); %>
                  </td>
                  <td>
                    <% out.println(listClient.get(i).getNameclient()); %>
                  </td>
                  <td>
                    <a href="IAMListVehiculClient?id=<% out.println(listClient.get(i).getId()); %>">vahicul</a>
                  </td>
                </tr>
                <% } %>
              </table>
            </div>
          </div>
          <div class="card mb-4">
            <div class="card-header">
              vehicul actif
            </div>

            <div class="card-body">
              <table class="table table-striped">
                <tr>
                  <th>
                    nom client
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
                    <a href="IAMListVehiculClient?id=<% out.println(listVehicul.get(i).getIdclient()); %>">
                      <% out.println(listClientNom.get(i).getNameclient()); %>
                    </a>
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