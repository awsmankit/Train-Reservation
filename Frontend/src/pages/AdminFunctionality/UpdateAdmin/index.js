import { Link } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const UpdateAdmin = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const [phone, setPhone] = useState("");
  const [address, setAddress] = useState("");
  const { id } = sessionStorage;
  const Firstname = sessionStorage["firstName"];
  const Lastname = sessionStorage["lastName"];
  const Email = sessionStorage["email"];
  const navigate = useNavigate();

  const updateAdmin = () => {
    if (firstName.length == 0) {
      toast.warning("Please enter first name");
    } else if (lastName.length == 0) {
      toast.warning("Please enter last name");
    } else if (email.length == 0) {
      toast.warning("Please enter email");
    } else {
      const body = {
        firstName,
        lastName,
        email,
        phone,
        address,
      };

      const url = `http://localhost:8080/admin/update/${id}`;

      axios.put(url, body).then((response) => {
        const result = response.data;
        console.log(result);
        if (result["status"] == "success") {
          toast.success("Profile Updated ");
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
      <h1 className="title">Update Profile</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                First Name
              </label>
              <input
                placeholder={Firstname}
                onChange={(e) => {
                  setFirstName(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Last Name
              </label>
              <input
                placeholder={Lastname}
                onChange={(e) => {
                  setLastName(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email Address
              </label>
              <input
                placeholder={Email}
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Phone
              </label>
              <input
                onChange={(e) => {
                  setPhone(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Address
              </label>
              <input
                onChange={(e) => {
                  setAddress(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <button onClick={updateAdmin} className="btn btn-primary">
                Update Admin Profile
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
export default UpdateAdmin;
