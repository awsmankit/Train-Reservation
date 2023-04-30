import { Link } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import { URL } from "../../../config";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const EditTrain = () => {
  const [no, setTrainNo] = useState("");
  const [trainName, setTrainName] = useState("");
  const [source, setSource] = useState("");
  const [arrivalTime, setArrivalTime] = useState("");
  const [destination, setDestination] = useState("");
  const [departureTime, setDepartureTime] = useState("");
  const [totalSeats, setTotalSeats] = useState("");
  const [Fair, setFair] = useState("");
  const { trainNoToEdit } = sessionStorage;
  const navigate = useNavigate();

  const editTrain = () => {
    if (arrivalTime.length == 0) {
      toast.warning("Please enter ArrivalTime");
    } else if (departureTime.length == 0) {
      toast.warning("Please enter DepartureTime");
    } else if (totalSeats.length == 0) {
      toast.warning("Please enter TotalSeates");
    } else if (Fair.length == 0) {
      toast.warning("Please enter Fair");
    } else {
      const body = {
        arrivalTime,
        departureTime,
        totalSeats,
        Fair,
      };

      const url = `${URL}/train/editTrain/${trainNoToEdit}`;

      axios.patch(url, body).then((response) => {
        const result = response.data;

        if (result["status"] == "success") {
          toast.success("Successfully edited train");

          // navigate to the adminHome page
          navigate("/adminHome");
        } else {
          toast.error("train not found");
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
              <button onClick={editTrain} className="btn btn-primary">
                Edit Train
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
export default EditTrain;
