import { useState, useEffect } from "react";
import { useNavigate } from "react-router";
import { toast } from "react-toastify";

const ReviewTrain = () => {
  const navigate = useNavigate();
  const [trainDetails, setTrainDetails] = useState([]);
  const [passengerDetails, setPassengerDetails] = useState([]);

  useEffect(() => {
    const storedTrainDetails = JSON.parse(
      sessionStorage.getItem("trainDetails")
    );
    const storedPassengerDetails = JSON.parse(
      sessionStorage.getItem("passengerDetails")
    );

    if (storedTrainDetails && storedPassengerDetails) {
      setTrainDetails(storedTrainDetails);
      setPassengerDetails(storedPassengerDetails);
    }
  }, []);

  //   const onBookHandler = (trainData) => {
  //     sessionStorage.setItem("trainData", JSON.stringify(trainData));
  //     const isLogin = sessionStorage.getItem("loginStatus");
  //     sessionStorage.setItem("trainNo", trainData[0]);
  //     if (isLogin) {
  //       navigate("/bookTicket");
  //     } else {
  //       navigate("/signin");
  //     }
  //   };

  return (
    <div className="container mt-4">
      <div className="row mb-4">
        <div className="col-12">
          <h2>Review Details</h2>
        </div>
      </div>
      <div className="row mb-4">
        <div className="col-md-6">
          <div className="card">
            <div className="card-header">
              <h3>Train Details</h3>
            </div>
            <div className="card-body">
              <div className="row">
                <div className="col-4">Train Number:</div>
                <div className="col-8">{trainDetails.trainNumber}</div>
              </div>
              <div className="row">
                <div className="col-4">Train Name:</div>
                <div className="col-8">{trainDetails.trainName}</div>
              </div>
              <div className="row">
                <div className="col-4">From:</div>
                <div className="col-8">{trainDetails.from}</div>
              </div>
              <div className="row">
                <div className="col-4">To:</div>
                <div className="col-8">{trainDetails.to}</div>
              </div>
              <div className="row">
                <div className="col-4">Date of Journey:</div>
                <div className="col-8">{trainDetails.dateOfJourney}</div>
              </div>
            </div>
          </div>
        </div>
        <div className="col-md-6">
          <div className="card">
            <div className="card-header">
              <h3>Passenger Details</h3>
            </div>
            <div className="card-body">
              {passengerDetails.map((passenger, index) => (
                <div className="row mb-3" key={index}>
                  <div className="col-4">Name:</div>
                  <div className="col-8">{passenger.name}</div>
                  <div className="col-4">Gender:</div>
                  <div className="col-8">{passenger.gender}</div>
                  <div className="col-4">Age:</div>
                  <div className="col-8">{passenger.age}</div>
                  <div className="col-4">Phone:</div>
                  <div className="col-8">{passenger.phoneNo}</div>
                  <div className="col-4">Region:</div>
                  <div className="col-8">{passenger.region}</div>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ReviewTrain;
