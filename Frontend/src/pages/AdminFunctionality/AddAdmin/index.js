import { Link } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const AddAdmin = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const navigate = useNavigate();

  const addAdmin = () => {
    if (firstName.length === 0) {
      toast.warning("Please enter first name");
    } else if (lastName.length === 0) {
      toast.warning("Please enter last name");
    } else if (email.length === 0) {
      toast.warning("Please enter email");
    } else if (password.length === 0) {
      toast.warning("Please enter password");
    } else if (confirmPassword.length === 0) {
      toast.warning("Please confirm your password");
    } else if (password !== confirmPassword) {
      toast.warning("Password does not match");
    } else {
      const body = {
        firstName,
        lastName,
        email,
        password,
      };

      const url = "http://localhost:8080/admin/addAdmin";

      axios.post(url, body).then((response) => {
        const result = response.data;
        console.log(result);
        if (result.status === "success") {
          toast.success("Successfully signed up new user");
          navigate("/adminHome");
        } else {
          toast.error(result.error);
        }
      });
    }
  };

  return (
    <div className="container">
      <Header />
      <h1 className="title">Add New Admin</h1>
      <div className="row">
        <div className="col"></div>
        <div className="col-6">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="form-label">
                First Name
              </label>
              <input
                onChange={(e) => {
                  setFirstName(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="form-label">
                Last Name
              </label>
              <input
                onChange={(e) => {
                  setLastName(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="form-label">
                Email Address
              </label>
              <input
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="form-label">
                Password
              </label>
              <input
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
                type="password"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <label htmlFor="" className="form-label">
                Confirm Password
              </label>
              <input
                onChange={(e) => {
                  setConfirmPassword(e.target.value);
                }}
                type="password"
                className="form-control"
              />
            </div>
            <div className="mb-3">
              <button onClick={addAdmin} className="btn btn-primary">
                Add Admin
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
export default AddAdmin;
