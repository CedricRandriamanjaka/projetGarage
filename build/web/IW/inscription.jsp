<%@include file="../CSS/header.jsp" %>


<div id="layoutAuthentication" style="background-color: rgb(33, 37, 41);">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header">
                                <h3 class="text-center font-weight-light my-4">inscription</h3>
                            </div>
                            <div class="card-body">
                                <% if(request.getParameter("ERROR")!=null){ %>
                                        <div class="card bg-danger text-white mb-4">
                                            <div class="card-footer d-flex align-items-center justify-content-between">
                                                ! <% out.print(request.getParameter("ERROR")); %>
                                            </div>
                                        </div>
                                    <% } %>
                                <form form action="IWInscriptionClient" method="post">
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputEmail" type="text"
                                               placeholder="votre nom" name="nameclient" required=""/>
                                        <label for="inputEmail">nom d utilisateur</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputPassword" type="password"
                                               placeholder="mot de passe" name="passwordclient" required=""/>
                                        <label for="inputPassword">mot de passe</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputPassword" type="password"
                                               placeholder="confirmation" name="passwordclientValider" required=""/>
                                        <label for="inputPassword">confirmation de mot de passe</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" required>
                                        <label class="form-check-label" for="flexCheckDefault">
                                          j ai lue et j approuve les condition d utilisation
                                        </label>
                                      </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <input class="btn btn-primary" type="submit" value="s inscrire">
                                    </div>
                                </form>
                            </div>

                            <div class="card-footer text-center py-3">
                                <div class="small"><a href="index.jsp">se connecte</a></div>
                            </div>
                        </div>
                    </div>
                                
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-body">
                                <h5 style="color:green;">Condition d'utilisation</h5>
                                <div class="card-body" style="background: rgb(240, 240, 240);
                                                                color: grey;">
                                    <li>evite de faire des reservation de parking inutile</li>
                                    <li>respecte le votre delai de parking</li>
                                    <li>respecte les autre membre en evitent de voler leur parking</li>
                                    <li>faire une demande de parking necessite 1 jours d avance</li>
                                    <li>il est interdit de se stasionne au delat de 24h</li>
                                    <li>tous tentative de fraude peut entraine a des sonction</li>
                                    <li>degrade les slot de parking entraine des sonction</li>
                                    <li>en cas de probleme contacte les admnistrateur</li>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <%@include file="../CSS/footer.jsp" %>
</div>

