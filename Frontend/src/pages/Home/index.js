import { useState } from "react";
import { Link } from "react-router-dom";
import "./index.css";
import { Component } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import logo from "../../images/logo.jpg";
import Footer from "../../components/Footer";

const Home = () => {
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [date, setDate] = useState("");
  const { firstName, lastName } = sessionStorage;
  const navigate = useNavigate();
  const [traindetails, setTraindetails] = useState([]);
  sessionStorage.clear();
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
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };

  function onBookHandler(trainData) {
    sessionStorage.setItem("trainData", trainData);
    let isLogin = sessionStorage.getItem("loginStatus");
    sessionStorage["trainNo"] = trainData.no;
    if (isLogin) {
      navigate("/bookTicket");
    } else {
      toast.success("please login first");
      navigate("/signin");
    }
  }

  const navigatetoSignin = () => {
    navigate("/signin");
  };

  const navigatetoSignup = () => {
    navigate("/signup");
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
              <th>Book</th>
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
      <div className="container-fixed">
        <nav class="navbar navbar-expand-lg navbar-light bg-light container-fluid">
          <a class="navbar-brand" href="#">
            <img src={logo} alt="" width="50" />
            SAFAR
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div
            class="collapse navbar-collapse justify-content-end"
            id="navbarNav"
          >
            <ul class="navbar-nav">
              <li class="nav-item active">
                <a class="nav-link" href="/Home">
                  Home
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/signin">
                  Sign in
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/signup">
                  Sign Up
                </a>
              </li>
            </ul>
          </div>
        </nav>
        <br></br>
        <br></br>
        <br></br>
        <div class="container mt-5 justify-content-center">
          <h3 class="text-center mb-5">WELCOME TO BOOK YOUR TRAIN</h3>
          <div class="row justify-content-center">
            <div class="col-lg-9">
              <div class="row ">
                <div class="col-lg-4">
                  <div class="form-group mb-3 ">
                    <label for="sourceSelect" class="form-label">
                      Source
                    </label>
                    <select
                      id="sourceSelect"
                      class="form-select"
                      aria-label="Select source"
                      onChange={(e) => setSource(e.target.value)}
                    >
                      <option value="none" selected>
                        Choose source
                      </option>
                      <option value="pune">Pune</option>
                      <option value="delhi">Delhi</option>
                      <option value="kolhapur">Kolhapur</option>
                      <option value="rajasthan">Rajasthan</option>
                    </select>
                  </div>
                </div>
                <div class="col">
                  <div class="form-group">
                    <label for="destinationSelect" class="form-label">
                      Destination
                    </label>
                    <select
                      id="destinationSelect"
                      class="form-select"
                      aria-label="Select destination"
                      onChange={(e) => setDestination(e.target.value)}
                    >
                      <option value="none" selected>
                        Choose destination
                      </option>
                      <option value="pune">Delhi</option>
                      <option value="mumbai">Mumbai</option>
                      <option value="chennai">Chennai</option>
                      <option value="tirupati">Tirupati</option>
                    </select>
                  </div>
                </div>
                <div class="col">
                  <div class="form-group">
                    <label for="dateInput" class="form-label">
                      Date
                    </label>
                    <input
                      id="dateInput"
                      type="date"
                      class="form-control"
                      onChange={(e) => setDate(e.target.value)}
                    />
                  </div>
                </div>
              </div>
            </div>
            <br></br>
            <div class="row mb-3">
              <div class="col-lg-9"></div>
              <div class="col-lg-12 d-flex justify-content-center py-3">
                <div
                  class="btn-group"
                  role="group"
                  aria-label="Button group with space between"
                >
                  <button
                    class="btn btn-primary"
                    type="button"
                    onClick={searchTrain}
                  >
                    Search
                  </button>
                  <button
                    class="btn btn-primary"
                    type="button"
                    onClick={searchTrain}
                  >
                    Reset
                  </button>
                </div>
              </div>
            </div>

            <br></br>
            <br></br>
            <div class="col">
              <div class="row">{renderTrainData()}</div>
            </div>
          </div>
        </div>
      </div>
      <Footer />
    </div>
  );
};
export default Home;
