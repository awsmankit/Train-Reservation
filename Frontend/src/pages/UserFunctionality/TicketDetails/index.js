import { useState } from "react";
import { Link } from "react-router-dom";

import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const TicketDetails = () => {
  const [ticketNo, setTicketNo] = useState("");
  const [ticketDetail, setTicketdetail] = useState("");

  const ticketDetails = () => {
    const url = `http://localhost:8080/ticket/details/${ticketNo}`;

    axios.get(url).then((response) => {
      const result = response.data;

      if (result["status"] == "success") {
        setTicketdetail(result["data"]);
        console.log(result);
        console.log(ticketDetail);
      } else {
        toast.error(result["error"]);
      }
    });
  };
  function renderTicketDetails() {
    return (
      ticketDetail &&
      ticketDetail.length > 0 && (
        <table className="table">
          <tr>
            <th>Ticket No</th>
            <th>Train No</th>
            <th>Name</th>
            <th>Date</th>
            <th>Arrival Time</th>
            <th>Dep Time</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Price</th>
            <th>Status</th>
          </tr>
          {ticketDetail.map((value, key) => {
            return (
              <tr key={key}>
                <td>{value[0]}</td>
                <td>{value[10]}</td>
                <td>{value[8]}</td>
                <td>{value[1]}</td>
                <td>{value[2]}</td>
                <td>{value[3]}</td>
                <td>{value[4]}</td>
                <td>{value[5]}</td>
                <td>{value[6]}</td>
                <td>{value[9]}</td>
              </tr>
            );
          })}
        </table>
      )
    );
  }

  return (
    <div>
      <Header />
      <div className="container">
        <br></br>
        <br></br>
        <br></br>
        <h3>Ticket Details</h3>
        <div className="form-group mb-3">
          <label className="form-label">Ticket No</label>
          <input
            onChange={(e) => {
              setTicketNo(e.target.value);
            }}
            type="text"
            className="form-control"
          />
        </div>
        <button onClick={ticketDetails} className="btn btn-info" type="button">
          Get ticket Details
        </button>
        <div className="table">
          {ticketDetail && ticketDetail.length > 0 && renderTicketDetails()}
        </div>
      </div>
      <Footer />
    </div>
  );
};
export default TicketDetails;
