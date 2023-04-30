import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import "./index.css";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import HomeLayout from "../../components/HomeLayout";
import Footer from "../../components/Footer";
import Header from "../../components/Header";

const Signin = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  useEffect(() => {
    // Define a function to handle form submission
    const handleSubmit = (event) => {
      event.preventDefault();
      if (email.length === 0) {
        toast.warning("please enter email");
      } else if (password.length === 0) {
        toast.warning("please enter password");
      } else {
        const body = {
          email,
          password,
        };
  
        const url = `http://localhost:8080/user/login`;
  
        // make api call using axios
        axios.post(url, body).then((response) => {
          const result = response.data;
          console.log(result);
          if (result["status"] === "success") {
            toast.success("Welcome to the application");
  
            // get the data sent by server
            // get the data sent by server
            const { id, firstName, lastName } = result["data"];
  
            // persist the logged in user's information for future use
            sessionStorage["id"] = id;
            sessionStorage["firstName"] = firstName;
            sessionStorage["lastName"] = lastName;
            sessionStorage["loginStatus"] = 1;
  
            // navigate to home component
            navigate("/userHome");
          } else {
            toast.error(result["error"]);
          }
        });
      }
    }

    // Add a submit event listener to the form
    const form = document.getElementById("signin-form");
    form.addEventListener("submit", handleSubmit);

    // Clean up function to remove event listener
    return () => {
      form.removeEventListener("submit", handleSubmit);
    }
  }, [email, password, navigate]);

  const adminSignin = () => {
    if (email.length === 0) {
      toast.warning("please enter email");
    } else if (password.length === 0) {
      toast.warning("please enter password");
    } else {
      const body = {
        email,
        password,
      };
  
      const url = `http://localhost:8080/admin/login`;
  
      // make api call using axios
      axios.post(url, body).then((response) => {
        const result = response.data;
        console.log(result);
        if (result["status"] === "success") {
          toast.success("Welcome to the application");
  
          // get the data sent by server
          // get the data sent by server
          const { id, firstName, lastName } = result["data"];
  
          // persist the logged in user's information for future use
          sessionStorage["id"] = id;
          sessionStorage["firstName"] = firstName;
          sessionStorage["lastName"] = lastName;
          sessionStorage["loginStatus"] = 1;
  
          // navigate to home component
          navigate("/adminHome");
        } else {
          toast.error(result["error"]);
        }
      });
    }
  };



  return (
    <div className="container-fixed">
      <Header />
      <br></br>
      <br></br>
      <h1 className="title">Signin</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                Email address
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
              <label htmlFor="" className="label-control">
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
              <div>
                No account yet? <Link to="/signup">Signup here</Link>
              </div>
              <button onClick={userSignin} className="btn btn-primary">
                UserSignin
              </button>{" "}
              <span> </span>
              <button onClick={adminSignin} className="btn btn-primary">
                AdminSignin
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

export default Signin;
