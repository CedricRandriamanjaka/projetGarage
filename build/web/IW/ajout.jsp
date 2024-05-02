<%@include file="IWheader.jsp" %>

<%@page import="Model.Vehicul"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">ajout de nouveau vehicul</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Vehicule   /   Ajout de vahicule</li>
                    </ol>

                    <div class="row">
                        <div class="col-xl-6">
                            <div class="card mb-4">
                                <div class="card-header">
                                    nouveau vehicul
                                </div>

                                <div class="card-body">
                                    <% if(request.getParameter("ERROR")!=null){ %>
                                        <div class="card bg-danger text-white mb-4">
                                            <div class="card-footer d-flex align-items-center justify-content-between">
                                                <% out.print(request.getParameter("ERROR")); %>
                                            </div>
                                        </div>
                                    <% } %>
                                    <form action="IWAjoutClient" method="post">
                                        <label for="">type de vehicul</label>
                                        <select name="typevehicul" id="" class="form-control">
                                            <option value="classique">voiture classique</option>
                                            <option value="moto">moto</option>
                                            <option value="camion">camion</option>
                                            <option value="autre">autre</option>
                                        </select>
                            
                                        <label for="">marque</label>
                                        <input type="text" name="marquevehicul"  class="form-control" required>
                            
                                        <label for="">model</label>
                                        <input type="text" name="modelvehicul"  class="form-control" required>
                            
                                        <label for="">color</label>
                                        <select name="colorvehicul"  class="form-control">s
                                            <option value="noir">noir</option>
                                            <option value="blanc">blanc</option>
                                            <option value="rouge">rouge</option>
                                            <option value="bleu">bleu</option>
                                        </select>
                            
                                        <label for="">matriculation</label>
                                        <input type="text" name="matriculationvehicul"  class="form-control" required>
                                        
                                        <br>
                                        <h4>dimention du vehicul</h4>
                            
                                        <label for="">longueur</label>
                                        <input type="number" name="longvehicul" id="" placeholder="en centimetre" class="form-control" required>
                            
                                        <label for="">largueur</label>
                                        <input type="number" name="largvehicul" id="" placeholder="en centimetre" class="form-control" required>
                            
                                        <label for="">heuteur</label>
                                        <input type="number" name="hautvehicul" id="" placeholder="en centimetre" class="form-control" required>
                            
                                        <label for="">poid</label>
                                        <input type="numer" name="poidvehicul" id="" placeholder="en kg" class="form-control" required><br>
                            
                                        <a href="acceuil.jsp"><button>annuler</a></button> <input type="submit" value="enregistre" class="btn btn-primary">
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
