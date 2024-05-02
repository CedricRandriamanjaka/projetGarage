<%@include file="../CSS/header.jsp" %>

    <div id="layoutAuthentication" style="background-color: rgb(33, 37, 41);">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header">
                                    <h3 class="text-center font-weight-light my-4">identification</h3>
                                </div>
                                <div class="card-body">
                                    <% if(request.getParameter("ERROR")!=null){ %>
                                        <div class="card bg-danger text-white mb-4">
                                            <div class="card-footer d-flex align-items-center justify-content-between">
                                               <% out.print(request.getParameter("ERROR")); %>
                                            </div>
                                        </div>
                                    <% } %>
                                    <% if(request.getParameter("CHECK")!=null){ %>
                                        <div class="card bg-success text-white mb-4">
                                            <div class="card-footer d-flex align-items-center justify-content-between">
                                               <% out.print(request.getParameter("CHECK")); %>
                                            </div>
                                        </div>
                                    <% } %>
                                    
                                    
                                    <form form action="IWLoginClient" method="post">
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputEmail" type="text"
                                                placeholder="votre nom" name="nameclient" required/>
                                            <label for="inputEmail">nom d utilisateur</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputPassword" type="password"
                                                placeholder="mot de passe" name="passwordclient" required/>
                                            <label for="inputPassword">mot de passe</label>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                            <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                            <input class="btn btn-primary" type="submit" value="se connecter">
                                        </div>
                                    </form>
                                </div>

                                <div class="card-footer text-center py-3">
                                    <div class="small"><a href="inscription.jsp">s'inscrire</a></div>
                                </div>
                            </div>
                        </div>
                                    
                    </div>
                </div>
            </main>
        </div>
        <%@include file="../CSS/footer.jsp" %>
    </div>
