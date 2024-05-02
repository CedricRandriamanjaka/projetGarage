<%@include file="IAMheader.jsp" %>

<%@page import="Model.Vehicul" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

    <div id="layoutSidenav_content">
      <main>
        <div class="container-fluid px-4">
          <h1 class="mt-4">Ajout de nouveau slot</h1>
          <ol class="breadcrumb mb-4">
          <li class="breadcrumb-item active">verifier les donner avant de confirmer</li>
          </ol>

          <div class="row">
            <div class="col-xl-6">
              <div class="card mb-4">
                <div class="card-header">
                  details du nouveau slot
                </div>

                <div class="card-body">
                  <form action="IAMAjoutSlot" method="post">
                    <label for="">nom de slot</label><br>
                    <input type="text" name="nameslot" class="form-control"><br>
                    <h4>dimention</h4>
                    <label for="">longueur</label><br>
                    <input type="number" name="longueur" id="" class="form-control"><br>
                    <label for="">largueur</label><br>
                    <input type="number" name="largueur" id="" class="form-control"><br>
                    <label for="">hauteur</label><br>
                    <input type="number" name="hauteur" id="" class="form-control"><br>
                    <label for="">poid max</label><br>
                    <input type="number" name="poid" id="" class="form-control"><br>
                    <input type="submit" value="valider" class="btn btn-primary"><br>
                  </form>
                </div>
              </div>
            </div>
              
            <div class="col-xl-6">
              <div class="card mb-4">
                <div class="card-header">
                    importation de fichier
                </div>

                <div class="card-body">
                  <form action="IAMAjoutSlot" method="get">
                      <input type="file" name="namefile" class="form-control" value="" id="fileUpload" required><br>
                        <input name="import" type="submit" value="importer" class="btn btn-primary"><br>
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