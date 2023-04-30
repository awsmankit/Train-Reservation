import { Link } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import { URL } from "../../../config";
import Footer from "../../../components/Footer";
import Header from "../../../components/Header";

const AddTrain = () => {
  const [no, setTrainNo] = useState("");
  const [trainName, setTrainName] = useState("");
  const [source, setSource] = useState("");
  const [arrivalTime, setArrivalTime] = useState("");
  const [destination, setDestination] = useState("");
  const [departureTime, setDepartureTime] = useState("");
  const [totalSeats, setTotalSeats] = useState("");
  const [fair, setFair] = useState("");

  const navigate = useNavigate();

  const addTrain = () => {
    if (no.length == 0) {
      toast.warning("Please enter TrainNo");
    } else if (trainName.length == 0) {
      toast.warning("Please enter TrainName");
    } else if (source.length == 0) {
      toast.warning("Please enter Source");
    } else if (arrivalTime.length == 0) {
      toast.warning("Please enter ArrivalTime");
    } else if (destination.length == 0) {
      toast.warning("Please enter Destination");
    } else if (departureTime.length == 0) {
      toast.warning("Please enter DepartureTime");
    } else if (totalSeats.length == 0) {
      toast.warning("Please enter TotalSeates");
    } else if (fair.length == 0) {
      toast.warning("Please enter Fair");
    } else {
      const body = {
        no,
        trainName,
        source,
        arrivalTime,
        destination,
        departureTime,
        totalSeats,
        fair,
      };

      const url = `${URL}/train/addtrain`;

      axios.post(url, body).then((response) => {
        const result = response.data;

        if (result["status"] == "success") {
          toast.success("Successfully added new train");

          // navigate to the adminHome page
          navigate("/adminHome");
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };

  return (
    <div>
      <Header />
      <h1 className="title">TrainAdd</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                TrainNo
              </label>
              <input
                onChange={(e) => {
                  setTrainNo(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                TrainName
              </label>
              <input
                onChange={(e) => {
                  setTrainName(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

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
                ArrivalTime
              </label>
              <input
                onChange={(e) => {
                  setArrivalTime(e.target.value);
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
                DepartureTime
              </label>
              <input
                onChange={(e) => {
                  setDepartureTime(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                TotalSeats
              </label>
              <input
                onChange={(e) => {
                  setTotalSeats(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Fair
              </label>
              <input
                onChange={(e) => {
                  setFair(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <button onClick={addTrain} className="btn btn-primary">
                AddTrain
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
      <Footer />
    </div>
  );
};
export default AddTrain;
