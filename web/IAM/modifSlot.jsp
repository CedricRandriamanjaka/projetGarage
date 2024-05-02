<%@page import="Model.Slot"%>
<%@include file="IAMheader.jsp" %>

<%@page import="Model.Vehicul" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<% Slot s = (Slot)session.getAttribute("modifSlot"); %>

    <div id="layoutSidenav_content">
      <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Modification du Slot : <% out.print(s.getNameslot()); %></h1>
          <ol class="breadcrumb mb-4">
          <li class="breadcrumb-item active">Slot / modification</li>
          </ol>

          <div class="row">
            <div class="col-xl-6">
              <div class="card mb-4">
                <div class="card-header">
                  donnee a modifier du slot
                </div>

                <div class="card-body">
                  <form action="IAMModif" method="post">
                    <label for="">nom de slot</label><br>
                    <input type="text" name="nameslot" class="form-control" value="<% out.print(s.getNameslot()); %>"><br>
                    <h4>dimention</h4>
                    <label for="">longueur</label><br>
                    <input type="number" name="longueur" id="" class="form-control" value="<% out.print(s.getLongslot()); %>"><br>
                    <label for="">largueur</label><br>
                    <input type="number" name="largueur" id="" class="form-control" value="<% out.print(s.getLargslot()); %>"><br>
                    <label for="">hauteur</label><br>
                    <input type="number" name="hauteur" id="" class="form-control" value="<% out.print(s.getHautslot()); %>"><br>
                    <label for="">poid max</label><br>
                    <input type="number" name="poid" id="" class="form-control" value="<% out.print(s.getPoidslot()); %>"><br>
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            tous les reservation sur ce slot seront annuler
                        </label>
                    </div><br>
                    <input name="etat" type="submit" value="modifier" class="btn btn-warning"><br>
                  </form>
                </div>
              </div>
            </div>
                    
                    
            <div class="col-xl-6">
              <div class="card mb-4">
                <div class="card-header">
                  suppresion du slot
                </div>

                <div class="card-body">
                  <form action="IAMModif" method="post">
                      
                    <h5 style="color:red;">consequence de suppresion</h5>
                    <div class="card-body" style="background: rgb(240, 240, 240);
                                                                color: grey;">
                        <li>ne supprimer un slot quand cas de besoin</li>
                        <li>supprimer un slot annulera tous reservation via ce slot</li>
                        <li>il est preferable de change les dimention du <br> parking en <b>poid : 0</b> pour desactiver le parking temporairement</li>
                                               
                        <li>la suppresion de slot est prevus pour supprimer les parking reelement supprimer</li>
                        <li>la suppresion de slot entrainera la suppresion des reservation comprise avec celle ci</li>
                    </div><br>
                    
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" required>
                        <label class="form-check-label" for="flexCheckDefault">
                            je suis sure de vouloir supprimer ce slot
                        </label>
                    </div><br>
                    <input name="etat" type="submit" class="btn btn-danger" value="suppimer">
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