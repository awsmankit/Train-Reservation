import { useState } from "react";
import { Link } from "react-router-dom";

import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
//import Train from '../train'

//import PassangerDetails from '../Passanger Details/passanger.details'

const SearchTrain = () => {
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [date, setDate] = useState("");
  const { firstname, lastname } = sessionStorage;
  const navigate = useNavigate();
  const [traindetails, setTraindetails] = useState([]);

  const searchTrain = () => {
    if (source.length == 0) {
      toast.warning("please enter email");
    } else if (destination.length == 0) {
      toast.warning("please enter password");
    } else if (destination.length == 0) {
      toast.warning("please enter password");
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

          const trainNo = result.data[0].no;
          const trainDate = date;
          // sessionStorage['trainNo'] = trainNo  //not getting for individual train
          sessionStorage["trainDate"] = trainDate;

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
    // const tno=trainData.no;
    // console.log(tno);
    sessionStorage["trainNo"] = trainData.no;

    if (isLogin) {
      navigate("/bookTicket");
    } else {
      navigate("/signin");
    }
  }

  function renderTrainData() {
    return (
      traindetails &&
      traindetails.length > 0 && (
        <table>
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
          {traindetails.map((val, key) => {
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
                  <button onClick={() => onBookHandler(val)}>Book</button>
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
      <div className="row">
        <table>
          <tr>
            <td>
              <div className="col">
                <div className="form">
                  <div className="mb-3">
                    <label htmlFor="" className="label-control">
                      Source
                    </label>
                    <input
                      onChange={(e) => {
                        setSource(e.target.value);
                      }}
                      type="text"
                      className="form-control"
                    />
                  </div>

                  <div className="mb-3">
                    <label htmlFor="" className="label-control">
                      Destination
                    </label>
                    <input
                      onChange={(e) => {
                        setDestination(e.target.value);
                      }}
                      type="text"
                      className="form-control"
                    />
                  </div>

                  <div className="mb-3">
                    <label htmlFor="" className="label-control">
                      Destination
                    </label>
                    <input
                      onChange={(e) => {
                        setDate(e.target.value);
                      }}
                      type="date"
                      data-date-format="YYYY-MM-DD"
                      className="form-control"
                    />
                  </div>

                  <div className="mb-3">
                    <button onClick={searchTrain} className="btn btn-primary">
                      Search
                    </button>
                  </div>
                </div>
              </div>
            </td>
            <td colSpan="2">
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
            </td>
          </tr>
        </table>
        <div class="row">{renderTrainData()}</div>
      </div>
    </div>
  );
};

export default SearchTrain;
