    <%@page import="util.SlotWithReservation"%>
    <%@page import="Model.Slot"%>
    <%@page import="Model.Reservation" %>
    <%@page import="java.util.ArrayList" %>
    <% ArrayList<SlotWithReservation> listSlot = (ArrayList<SlotWithReservation>)session.getAttribute("listSlotWithReservationTrue"); %>
    <% String idpage=request.getParameter("page"); %>
    <% int p = Integer.valueOf(idpage);  %>
    <% int pagemax = (listSlot.size()/8)+1; %>
    <% if(p<1){ p=1; } if(p>pagemax){ p=pagemax; } %>
    
    
    
    <%@include file="IAMheader.jsp" %>

    <div id="layoutSidenav_content">
      <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Slor de parking</h1>
            <ol class="breadcrumb mb-4">
                <button class="btn btn-warning"><a href="IAMListSlot">actualise</a></button>
            </ol>
            
            <div class="card mb-4">
                <div class="card-header">
                    critere de recherche
                </div>

                <div class="card-body">
                    <form action="IAMListSlot" method="post">
                        <div class="row">
                            <div class="col-xl-2"> 
                                <div class="card">
                                  <div class="card-body">
                                        <label for="">reservation minimum</label><br>
                                        <input type="number" name="reservationMin" id="" class="form-control"><br>
                                  </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-2"> 
                                <div class="card">
                                  <div class="card-body">
                                        <label for="">reservation maximum</label><br>
                                        <input type="number" name="reservationMax" id="" class="form-control"><br>
                                  </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-3"> 
                                <div class="card">
                                  <div class="card-body">
                                        <label for="">poid minimum</label><br>
                                        <input type="number" name="poidMin" id="" class="form-control"><br>
                                  </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-3"> 
                                <div class="card">
                                  <div class="card-body">
                                        <label for="">poid maximum</label><br>
                                        <input type="number" name="poidMax" id="" class="form-control"><br>
                                  </div>
                                </div>
                            </div>
                            
                            <div class="col-xl-2"> 
                                        <input type="submit" id="" class="btn btn-primary"><br>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

          <div class="card mb-4">
            <div class="card-header">
              Slot de parking actif
            </div>

            <div class="card-body">
                
                <div class="row">
                    <nav aria-label="Page navigation example" style="margin: 0 auto;">
                        <ul class="pagination">
                          <li class="page-item">
                            <a class="page-link" href="listSlot.jsp?page=<% out.print(p-1); %>" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <% for(int i=1;i<=pagemax;i++){ %>
                          <li class="page-item"><a class="page-link" href="listSlot.jsp?page=<% out.print(i); %>"><% out.print(i); %></a></li>
                          <% } %>
                          <li class="page-item">
                            <a class="page-link" href="listSlot.jsp?page=<% out.print(p+1); %>" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                    </nav>
                    
                    <% for(int i=(p*8-8);i<listSlot.size();i++){ %>
                    <%  
                        if(i==(p*8)){
                            break;
                        }
                    %>

                    <div class="col-xl-3" style="padding-bottom: 1.5rem;"> 
                      <div class="card">
                        <div class="card-body">
                         <h5 class="card-title">Slot : <% out.println(listSlot.get(i).getSlot().getNameslot()); %></h5>
                           <h6 class="card-subtitle mb-2 text-muted"><% out.println(listSlot.get(i).getReservation().size()); %> reservation</h6>
                            <div class="card-body"  style="background: rgb(240, 240, 240);color: grey;">
                                <label>dimention : <% out.println(listSlot.get(i).getSlot().getLongslot()); %>x<% out.println(listSlot.get(i).getSlot().getLargslot()); %> cm</label><br>  
                                <label>hauteur : <% out.println(listSlot.get(i).getSlot().getHautslot()); %>cm</label><br>  
                                <label>poid : <% out.println(listSlot.get(i).getSlot().getPoidslot()); %>kg</label><br>  

                                <form action="IAMListReservation" method="get">
                                    <input name="idSlot" type="hidden" value="<% out.println(listSlot.get(i).getSlot().getId()); %>">
                                    <br>
                                    <input name="etat" type="submit" value="detail reservation">
                                </form>
                            </div>
                          <br>
                          <form action="IAMModif" method="get">
                            <input name="idSlot" type="hidden" value="<% out.println(listSlot.get(i).getSlot().getId()); %>">
                            <input name="etat" type="submit" class="btn btn-warning" value="modifier">
                          </form>
                        </div>
                      </div>
                    </div>

                    <% } %>
                    
                    <nav aria-label="Page navigation example" style="margin: 0 auto;">
                        <ul class="pagination">
                          <li class="page-item">
                            <a class="page-link" href="listSlot.jsp?page=<% out.print(p-1); %>" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>
                          <% for(int i=1;i<=pagemax;i++){ %>
                          <li class="page-item"><a class="page-link" href="listSlot.jsp?page=<% out.print(i); %>"><% out.print(i); %></a></li>
                          <% } %>
                          <li class="page-item">
                            <a class="page-link" href="listSlot.jsp?page=<% out.print(p+1); %>" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                    </nav>
                </div>
            </div>
          </div>
        </div>
      </main>
      <%@include file="../CSS/footer.jsp" %>
    </div>
    </div>
    </body>


