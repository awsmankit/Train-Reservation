

function HomeLayout()
{
    return(
          <div>
             
             <div>
      <meta charSet="utf-8" />
      <meta
        name="viewport"
        content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
      />
      <title>UserHome</title>
      <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css" />
      <link rel="stylesheet" href="assets/fonts/font-awesome.min.css" />
      <link rel="stylesheet" href="assets/fonts/ionicons.min.css" />
      <link
        rel="stylesheet"
        href="assets/css/Material-Style-Ripple-Button.css"
      />
      <link rel="stylesheet" href="assets/css/Button-Outlines---Pretty.css" />
      <link rel="stylesheet" href="assets/css/Footer-Basic.css" />
      <link rel="stylesheet" href="assets/css/styles.css" />
      <div className="container">
        <div className="row" />
      </div>
      <div className="container cool-btn-container">
        <div className="row">
          <div className="col">
            <div className="form-group mb-3">
              <label className="form-label">Source</label>
              <input type="text" className="form-control" />
            </div>
            <div className="form-group mb-3">
              <label className="form-label">Destination</label>
              <input type="text" className="form-control" />
            </div>
            <div className="form-group mb-3">
              <label className="form-label">Date</label>
              <input type="date" className="form-control" />
            </div>
            <button className="btn btn-info" type="button">
              Search Train&nbsp;
              <i className="icon ion-android-arrow-forward" />
            </button>
          </div>
          <div
            className="col-lg-2 d-flex flex-column py-3"
            style={{ margin: "0 auto" }}
          >
            <button className="btn btn-primary" type="button">
              Home
            </button>
            <br />
            <button className="btn btn-info" type="button">
              Profile
            </button>
            <br />
            <button className="btn btn-warning" type="button">
              My Transaction
            </button>
            <br />
            <button className="btn btn-danger" type="button">
              Cancel Ticket
            </button>
            <br />
            <button className="btn btn-dark" type="button">
              Ticket Status
            </button>
            <br />
            <button className="btn btn-dark" type="button">
              Logout
            </button>
            <br />
          </div>
        </div>
        
      </div>
    </div>


  
          </div>
    );
}
export default HomeLayout