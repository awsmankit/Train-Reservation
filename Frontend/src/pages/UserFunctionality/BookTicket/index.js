import { Link } from "react-router-dom";
import Header from "../../../components/Header";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";

const BookTicket = () => {
  const [name, setName] = useState("");
  const [gender, setGender] = useState("");
  const [phoneNo, setPhone] = useState("");
  const [region, setRegion] = useState("");
  const [age, setAge] = useState("");
  const [userData, setUserData] = useState([]);
  const [passengerCount, setPassengerCount] = useState(0);

  const { id } = sessionStorage;
  const { trainNo } = sessionStorage;
  const { trainDate } = sessionStorage;
  const navigate = useNavigate();

  const addpassenger = () => {
    let passanger = {};
    if (
      name.length === 0 ||
      gender.length === 0 ||
      phoneNo.length === 0 ||
      region.length === 0 ||
      age.length === 0
    ) {
      toast.warning("Please fill in all the details");
      return;
    }
    if (passengerCount >= 5) {
      toast.warning("Only 5 bookings are allowed with your ID");
      return;
    }

    passanger.name = name;
    passanger.gender = gender;
    passanger.phoneNo = phoneNo;
    passanger.region = region;
    passanger.age = age;
    setUserData((oldArray) => [...oldArray, passanger]);
    setName("");
    setGender("");
    setAge("");
    setRegion("");
    setPhone("");
    setPassengerCount(passengerCount + 1);
  };

  const onPassangerDeletehandler = (index) => {
    setUserData([
      ...userData.slice(0, index),
      ...userData.slice(index + 1, userData.length),
    ]);
    setPassengerCount(passengerCount - 1);
  };

  // const bookPassangerTicket = () => {
  //   if (userData && userData.length) {
  //     const url = `http://localhost:8080/bookTicket/${trainNo}/${trainDate}/${id}`;
  //     axios.post(url, userData).then((response) => {
  //       const result = response.data;
  //       console.log(result);
  //       if (result["status"] == "success") {
  //         toast.success("ticket booked succefully!!");
  //         navigate("/review");
  //       } else {
  //         toast.error(result["error"]);
  //       }
  //     });
  //   }
  // };
  const bookPassangerTicket = () => {
    if (userData && userData.length) {
      // Store passenger data in session storage
      sessionStorage.setItem("passengerData", JSON.stringify(userData));
    }
    navigate("/review");
  };

  return (
    <div className="container-fixed">
      <Header />
      <br></br>
      <br></br>
      <div className="container">
        <h2>Book Ticket</h2>
        <div className="row">
          <div className="col-md-6">
            <div className="form-group">
              <label htmlFor="name">Name:</label>
              <input
                type="text"
                className="form-control"
                id="name"
                placeholder="Enter Name"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="gender">Gender:</label>
              <select
                className="form-control"
                id="gender"
                value={gender}
                onChange={(e) => setGender(e.target.value)}
              >
                <option value="">--Select--</option>
                <option value="M">Male</option>
                <option value="F">Female</option>
                <option value="O">Other</option>
              </select>
            </div>
            <div className="form-group">
              <label htmlFor="phoneNo">Phone No:</label>
              <input
                type="text"
                className="form-control"
                id="phoneNo"
                placeholder="Enter Phone No"
                value={phoneNo}
                onChange={(e) => setPhone(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="region">Region:</label>
              <input
                type="text"
                className="form-control"
                id="region"
                placeholder="Enter Region"
                value={region}
                onChange={(e) => setRegion(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="age">Age:</label>
              <input
                type="text"
                className="form-control"
                id="age"
                placeholder="Enter Age"
                value={age}
                onChange={(e) => setAge(e.target.value)}
              />
            </div>
            <br></br>
            <button
              type="button"
              className="btn btn-primary"
              onClick={() => addpassenger()}
            >
              Add Passenger
            </button>
          </div>
          <div className="col-md-6">
            <div className="card">
              <div className="card-header">Passenger Details</div>
              <table className="table table-bordered">
                <thead>
                  <tr>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Phone No</th>
                    <th>Region</th>
                    <th>Age</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {userData.map((passenger, index) => (
                    <tr key={index}>
                      <td>{passenger.name}</td>
                      <td>{passenger.gender}</td>
                      <td>{passenger.phoneNo}</td>
                      <td>{passenger.region}</td>
                      <td>{passenger.age}</td>
                      <td>
                        <button
                          type="button"
                          className="btn btn-sm btn-danger"
                          onClick={() => onPassangerDeletehandler(index)}
                        >
                          Delete
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
        <div className="row mt-2">
          <div className="col-md-6">
            <div className="form-group">
              <label>Total Passengers:</label>
              <span>{passengerCount}</span>
            </div>
          </div>
          <br></br>
          <div className="col-md-12">
            <button
              type="button"
              className="btn btn-success float-right"
              onClick={() => bookPassangerTicket()}
            >
              Book Ticket
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};
export default BookTicket;
