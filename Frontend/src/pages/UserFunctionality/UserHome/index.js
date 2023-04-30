import { useState } from "react";
import { Link } from "react-router-dom";
import "./index.css";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const UserHome = () => {
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [date, setDate] = useState("");
  const { firstName, lastName } = sessionStorage;
  const navigate = useNavigate();
  const [traindetails, setTraindetails] = useState([]);

  const searchTrain = () => {
    if (source.length == 0 || source == "none") {
      toast.warning("please enter source");
    } else if (destination.length == 0 || destination == "none") {
      toast.warning("please enter destination");
    } else if (date.length == 0) {
      toast.warning("please enter date");
    } else {
      const body = {
        source,
        destination,
        date,
      };

      const url = `http://localhost:8080/train/search`;

      // make api call using axios
      axios.post(url, body).then((response) => {
        const result = response.data;
        console.log(result);
        if (result["status"] == "success") {
          setTraindetails(result["data"]);

          // const trainNo = result.data[0].no;
          const trainDate = date;
          //sessionStorage['trainNo'] = trainNo
          sessionStorage["trainDate"] = trainDate;

          //  const { traindetails } = result['data']
          //   console.log(traindetails.trainNo);

          //navigate('/trainDetails', {state : {traindetails : traindetails}})
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };

  function onBookHandler(trainData) {
    sessionStorage.setItem("trainData", trainData);
    let isLogin = sessionStorage.getItem("loginStatus");
    sessionStorage["trainNo"] = trainData[0];
    if (isLogin) {
      navigate("/bookTicket");
    } else {
      navigate("/signin");
    }
  }
  const logoutUser = () => {
    // remove the logged users details from session storage
    // sessionStorage.removeItem('id')
    // sessionStorage.removeItem('firstName')
    // sessionStorage.removeItem('lastName')
    // sessionStorage.removeItem('loginStatus')
    // sessionStorage.removeItem('trainNo')
    sessionStorage.clear();

    // navigate to sign in component
    navigate("/signin");
  };
  const navigatetoUserProfile = () => {
    navigate("/updateUser");
  };

  const Cancelticket = () => {
    navigate("/cancelTicket");
  };

  const TicketDetails = () => {
    navigate("/ticketDetails");
  };

  const onMytransactionhandler = () => {
    navigate("/mytrasnaction");
  };

  function renderTrainData() {
    return (
      traindetails &&
      traindetails.length > 0 && (
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Train No</th>
              <th>Train Name</th>
              <th>Source</th>
              <th>Arrival Time</th>
              <th>Destination</th>
              <th>Departure Time</th>
              <th>Total Seats</th>
              <th>Available Seats</th>
              <th>Fair</th>
              <th>Action</th>
            </tr>
          </thead>
          {traindetails.map((val, key) => {
            return (
              <tr key={key}>
                <td>{val[0]}</td>
                <td>{val[1]}</td>
                <td>{val[2]}</td>
                <td>{val[3]}</td>
                <td>{val[4]}</td>
                <td>{val[5]}</td>
                <td>{val[6]}</td>
                <td>{val[8]}</td>
                <td>{val[7]}</td>
                <td>
                  {val[9] !== 0 && (
                    <button
                      className="btn btn-primary"
                      onClick={() => onBookHandler(val)}
                    >
                      Book
                    </button>
                  )}
                </td>
              </tr>
            );
          })}
        </table>
      )
    );
  }

  return (
    <div>
      <Header />
      <br></br>
      <br></br>
      <br></br>
      <div class="container my-3">
        <h3 class="mb-3">BOOK TICKET</h3>
        <h4>Hello {firstName}</h4>
        <div class="row">
          <div class="col-lg-9">
            <div class="row">
              <div class="col-lg-4">
                <div class="form-group mb-3">
                  <label class="form-label">Source</label>
                  <select
                    onChange={(e) => {
                      setSource(e.target.value);
                    }}
                    class="form-select"
                    aria-label="Default select example"
                  >
                    <option selected value="none">
                      Choose source
                    </option>
                    <option value="pune">pune</option>
                    <option value="delhi">delhi</option>
                    <option value="kolhapur">kolhapur</option>
                    <option value="Rajasthan">Rajasthan</option>
                  </select>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="form-group mb-3">
                  <label class="form-label">Destination</label>
                  <select
                    onChange={(e) => {
                      setDestination(e.target.value);
                    }}
                    class="form-select"
                    aria-label="Default select example"
                  >
                    <option selected value="none">
                      Choose destination
                    </option>
                    <option value="Pune">pune</option>
                    <option value="mumbai">mumbai</option>
                    <option value="chennai">chennai</option>
                    <option value="tirupati">tirupati</option>
                  </select>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="form-group mb-3">
                  <label class="form-label">Date</label>
                  <input
                    onChange={(e) => {
                      setDate(e.target.value);
                    }}
                    type="date"
                    class="form-control"
                  />
                </div>
              </div>
            </div>
            <button onClick={searchTrain} class="btn btn-primary" type="button">
              Search Train&nbsp;
              <i class="icon ion-android-arrow-forward" />
            </button>
          </div>
          <div class="col-lg-2 d-flex flex-column py--8 ">
            <button
              onClick={navigatetoUserProfile}
              class="btn btn-primary  mb-3"
              type="button"
            >
              Profile
            </button>
            <button
              onClick={onMytransactionhandler}
              class="btn btn-primary  mb-3"
              type="button"
            >
              My Transaction
            </button>
            <button
              onClick={Cancelticket}
              class="btn btn-primary mb-3"
              type="button"
            >
              Cancel Ticket
            </button>
            <button
              onClick={TicketDetails}
              class="btn btn-primary  mb-3"
              type="button"
            >
              Ticket Status
            </button>
          </div>

          <br />
        </div>
        <div class="row">{renderTrainData()}</div>
      </div>

      <Footer />
    </div>
  );
};

export default UserHome;
