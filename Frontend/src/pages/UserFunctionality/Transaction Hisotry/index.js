import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import "./transaction.css";
import Header from "../../../components/Header";
import Footer from "../../../components/Footer";

const MyTransactions = () => {
  const { id } = sessionStorage;
  const [ticketDetail, setTicketdetail] = useState("");
  const [isUpComing, setUpComing] = useState(false);

  function AllTransactions() {
    const url = `http://localhost:8080/ticket/all/${id}`;

    axios.get(url).then((response) => {
      const result = response.data;

      if (result["status"] == "success") {
        setTicketdetail(result["data"]);
        setUpComing(false);
      } else {
        toast.error(result["error"]);
      }
    });
  }

  function PastTransactions() {
    const url = `http://localhost:8080/ticket/past/${id}`;

    axios.get(url).then((response) => {
      const result = response.data;

      if (result["status"] == "success") {
        setTicketdetail(result["data"]);
        console.log(result);
        setUpComing(false);
        // console.log(ticketDetail);
      } else {
        toast.error(result["error"]);
      }
    });
  }

  function UpcomingTransactions() {
    const url = `http://localhost:8080/ticket/upcoming/${id}`;

    axios.get(url).then((response) => {
      const result = response.data;

      if (result["status"] == "success") {
        setTicketdetail(result["data"]);
        console.log(result);
        setUpComing(true);
        // console.log(ticketDetail);
      } else {
        toast.error(result["error"]);
      }
    });
  }

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
        // console.log(ticketDetail);
      } else {
        toast.error(result["error"]);
      }
    });
  }
  useEffect(() => {
    AllTransactions();
    console.log("getting called");
  }, []);

  function renderTicketDetails() {
    return (
      <table className="table">
        <tr>
          <th>Ticket No</th>
          <th>Train No</th>
          <th>Name</th>
          <th>Train Date</th>
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
              <td>
                {isUpComing && (
                  <button
                    onClick={() => {
                      onCancelHandler(value, key);
                    }}
                  >
                    Cancel
                  </button>
                )}
              </td>
            </tr>
          );
        })}
      </table>
    );
  }

  return (
    <div>
      <Header />
      <div className="title">
        <h3>My Transaction</h3>
      </div>
      <div className="buttons">
        <button
          onClick={AllTransactions}
          className={`btn btn-info`}
          type="button"
        >
          All Transactions
        </button>
        &nbsp; &nbsp;&nbsp;
        <button
          onClick={PastTransactions}
          className={`btn btn-info `}
          type="button"
        >
          Past Transactions
        </button>
        &nbsp; &nbsp;&nbsp;
        <button
          onClick={UpcomingTransactions}
          className="btn btn-info"
          type="button"
          class={`btn btn-info`}
        >
          Upcoming Transactions
        </button>
      </div>
      <div className="table">
        {ticketDetail && ticketDetail.length > 0 && renderTicketDetails()}
      </div>
      <Footer />
    </div>
  );
};
export default MyTransactions;
