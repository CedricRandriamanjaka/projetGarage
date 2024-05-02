<%@include file="IAMheader.jsp" %>

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
                  Navigation
                </div>

                <div class="card-body">
                  <a href="ajoutSlot.jsp">ajouter un slot de parking</a><br>
                  <a href="IAMListReservation">liste de reservation</a><br>
                  <a href="IAMListClient">liste de nos client et vehicul</a><br>
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
