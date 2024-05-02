<%@include file="../CSS/header.jsp" %>

<div id="layoutAuthentication" style="background-color: rgb(33, 37, 41);">
    <div id="layoutAuthentication_content">
        <main>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header">
                                <h3 class="text-center font-weight-light my-4">Administration</h3>
                            </div>
                            <div class="card-body">
                                <form form action="IAMLogin" method="post">
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputEmail" type="text"
                                            placeholder="votre nom" name="nameadmin"/>
                                        <label for="inputEmail">votre nom</label>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputPassword" type="password"
                                            placeholder="mot de passe" name="passwordadmin"/>
                                        <label for="inputPassword">votre mot de passe</label>
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                        <input class="btn btn-primary" type="submit" value="se connecte">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
    <%@include file="../CSS/footer.jsp" %>
</div>