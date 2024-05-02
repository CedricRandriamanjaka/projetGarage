<%@page import="Model.Reservation" %>
<%@page import="java.util.ArrayList" %>
<% ArrayList<Reservation> listReservation1 = (ArrayList<Reservation>)session.getAttribute("listReservationTrue"); %>
<% ArrayList<Reservation> listReservation2 = (ArrayList<Reservation>)session.getAttribute("listReservationFalse"); %>

<%@include file="IAMheader.jsp" %>

    <div id="layoutSidenav_content">
      <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Reservation</h1>
            <ol class="breadcrumb mb-4">
              <button><a href="IAMListReservation">actualise</a></button>
            </ol>

          <div class="card mb-4">
            <div class="card-header">
              reservation actif
            </div>

            <div class="card-body">
              <table class="table table-striped">
                <tr>
                  <th>
                    id reservation
                  </th>
                  <th>
                    id client
                  </th>
                  <th>
                    id vahicul
                  </th>
                  <th>
                    id slot
                  </th>
                  <th>
                    date reservation
                  </th>
                  <th>
                    heure
                  </th>
                  <th>
                    durree
                  </th>
                  <th>
                    valider
                  </th>
                  <th>
                    annuler
                  </th>
                </tr>
    
                <% for(int i=0;i<listReservation1.size();i++){ %>
                <tr>
                  <td>
                    <% out.println(listReservation1.get(i).getId()); %>
                  </td>
                  <td>
                    <% out.println(listReservation1.get(i).getIdclient()); %>
                  </td>
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
                    <% out.println(listReservation1.get(i).getValider()); %>
                  </td>
                  <td>
                    <form action="IAMListReservation" method="post">
                      <input type="hidden" name="id" value="<% out.println(listReservation1.get(i).getId()); %>">
                      <button type='submit' class="btn btn-primary" style="background-color: red;border: red;">annuler</button>
                    </form>
                  </td>
                </tr>
                <% } %>
              </table>
            </div>
          </div>
          <div class="card mb-4">
            <div class="card-header">
              reservation annuler
            </div>

            <div class="card-body">
              <table class="table table-striped">
                <tr>
                  <th>
                    id reservation
                  </th>
                  <th>
                    id client
                  </th>
                  <th>
                    id vahicul
                  </th>
                  <th>
                    id slot
                  </th>
                  <th>
                    date reservation
                  </th>
                  <th>
                    heure
                  </th>
                  <th>
                    durree
                  </th>
                  <th>
                    valider
                  </th>
                </tr>
    
                <% for(int i=0;i<listReservation2.size();i++){ %>
                <tr>
                  <td>
                    <% out.println(listReservation2.get(i).getId()); %>
                  </td>
                  <td>
                    <% out.println(listReservation2.get(i).getIdclient()); %>
                  </td>
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
                  <td>
                    <% out.println(listReservation2.get(i).getValider()); %>
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


