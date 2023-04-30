import { Link } from "react-router-dom";
import { useState } from "react";
import axios from "axios";
import "./index.css";
import { toast } from "react-toastify";
import { useEffect } from "react";
import { useLocation } from "react-router";
import AddTrain from "../AddTrain";
import { useNavigate } from "react-router";
import Footer from "../../../components/Footer";
import Header from "../../../components/Header";

const AdminHome = () => {
  const [trainNo, setTrainNo] = useState("");
  const navigate = useNavigate();
  //const [trainData, setTrainData] = useState([]);
  const [trainarray, setTrainArray] = useState([]);
  const { firstName } = sessionStorage;

  const searchTrainByNo = () => {
    if (trainNo.length == 0) {
      toast.warning("please enter Train number");
    } else {
      const body = {
        trainnumber: "trainNo",
      };

      const url = `http://localhost:8080/train/trainByNo/${trainNo}`;

      axios.get(url).then((response) => {
        const result = response.data;
        if (result["status"] == "success") {
          setTrainArray(result["data"]);

          console.log(trainarray);
          console.log(result);
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };
  function onDeleteHandler() {
    const url = `http://localhost:8080/train/delete/${trainNo}`;
    axios.delete(url).then((response) => {
      const result = response.data;
      if (result["status"] == "success") {
        toast.success("train is deleted ");
        console.log("train is deleted with trainNo" + trainNo);
      } else {
        toast.error("train not found");
      }
    });
  }

  function onEditHandler() {
    sessionStorage["trainNoToEdit"] = trainNo;
    navigate("/editTrain");
  }

  function AddTrain() {
    navigate("/addTrain");
  }

  function ScheduleTrain() {
    navigate("/scheduleTrain");
  }

  function AddAdmin() {
    // add agent instead ... make a see agent function and
    navigate("/addAdmin");
  }

  function UpdateAdmin() {
    navigate("/updateAdmin");
  }

  const logoutAdmin = () => {
    // remove the logged users details from session storage
    // sessionStorage.removeItem('id')
    // sessionStorage.removeItem('firstName')
    // sessionStorage.removeItem('lastName')
    // sessionStorage.removeItem('loginStatus')
    // sessionStorage.removeItem('trainDate')
    // sessionStorage.removeItem('trainData')
    sessionStorage.clear();

    // navigate to sign in component
    navigate("/signin");
  };

  return (
    <div>
      <Header />
      <div class="container">
        <br></br>
        <br></br>
        <h3>Admin HomePage</h3>
        <br></br>
        <h4> Hello {firstName} !</h4>

        <div className="container">
          <div className="row">
            <div className="col">
              <div className="form-group mb-3">
                <br></br>
                <label className="form-label">Enter Train Number</label>
                <input
                  onChange={(e) => {
                    setTrainNo(e.target.value);
                  }}
                  type="text"
                  className="form-control"
                />
              </div>

              <button
                onClick={searchTrainByNo}
                className="btn btn-info"
                type="button"
              >
                Search Train&nbsp;
                <i className="icon ion-android-arrow-forward" />
              </button>
            </div>
            <div
              className="col-lg-2 d-flex flex-column py-3"
              style={{ margin: "0 auto" }}
            >
              <button
                onClick={AddTrain}
                className="btn btn-primary"
                type="button"
              >
                Add Train
              </button>
              <br />
              <button
                onClick={ScheduleTrain}
                className="btn btn-primary"
                type="button"
              >
                Schedule Train
              </button>
              <br />
              <button
                onClick={AddAdmin}
                className="btn btn-primary"
                type="button"
              >
                Add Admin
              </button>
              <br />
            </div>
          </div>
        </div>

        <div class="row">
          {trainarray && trainarray.length > 0 && (
            <table className="trainDetails">
              <tr>
                <th>Train No</th>
                <th>TrainName</th>
                <th>Source</th>
                <th>Arrival Time</th>
                <th>Departure Time</th>
                <th>Destination</th>
                <th>TotalSeats</th>
                <th>Fair</th>
              </tr>
              {trainarray.map((val, key) => {
                return (
                  <tr key={key}>
                    <td>{val.no}</td>
                    <td>{val.trainName}</td>
                    <td>{val.source}</td>
                    <td>{val.arrivalTime}</td>
                    <td>{val.departureTime}</td>
                    <td>{val.destination}</td>
                    <td>{val.totalSeats}</td>
                    <td>{val.fair}</td>
                    <td>
                      <button onClick={() => onDeleteHandler()}>Delete</button>
                    </td>
                    <td>
                      <button onClick={() => onEditHandler()}>Edit</button>
                    </td>
                  </tr>
                );
              })}
            </table>
          )}
        </div>
      </div>
      <Footer />
    </div>
  );
};

export default AdminHome;
