import { useState } from "react";
import { Link } from "react-router-dom";

import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const CancelTicket = () => {
  const [ticketNo, setTicketNo] = useState("");
  const [ticketDetail, setTicketdetail] = useState("");
  const navigate = useNavigate();
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

  function onCancelHandler(value) {
    const seatNo = value[7];
    const status = "cancel";
    const trainNO = value[10];
    const trainDate = value[1];
    const passengerId = value[11];
    const url = `http://localhost:8080/ticket/cancelTicket/${seatNo}/${status}/${trainNO}/${trainDate}/${passengerId}`;
    axios.put(url).then((response) => {
      const result = response.data;
      console.log(seatNo, status, trainDate, trainNO, passengerId);
      if (result["status"] == "success") {
        console.log(result);

        toast.success("ticket cancel succefull !!");
        window.location.reload(false);
      } else {
        toast.error(result["error"]);
      }
    });
  }

  function renderTicketDetails() {
    return (
      ticketDetail &&
      ticketDetail.length > 0 && (
        <table className="table">
          <tr>
            <th>Ticket No</th>
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
                <td>{value[8]}</td>
                <td>{value[1]}</td>
                <td>{value[2]}</td>
                <td>{value[3]}</td>
                <td>{value[4]}</td>
                <td>{value[5]}</td>
                <td>{value[6]}</td>
                <td>{value[9]}</td>
                <td>
                  <button
                    onClick={() => {
                      onCancelHandler(value, key);
                    }}
                  >
                    Cancel
                  </button>
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
      <Header />
      <br></br>
      <div className="container">
        <h3>Cancel Ticket</h3>
        <div className="form-group mb-3">
          <label className="form-label" S>
            Ticket No{" "}
          </label>

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
export default CancelTicket;
