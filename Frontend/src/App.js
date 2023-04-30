import Signup from "./pages/UserFunctionality/Signup";
import { BrowserRouter, Route, Routes, Link } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Signin from "./pages/Signin";
import Home from "./pages/Home";

import BookTicket from "./pages/UserFunctionality/BookTicket";
import AdminHome from "./pages/AdminFunctionality/AdminHome";
import AddTrain from "./pages/AdminFunctionality/AddTrain";
import Scheduletrain from "./pages/AdminFunctionality/ScheduleTrain";
import EditTrain from "./pages/AdminFunctionality/EditTrain";
import AddAdmin from "./pages/AdminFunctionality/AddAdmin";
import UpdateAdmin from "./pages/AdminFunctionality/UpdateAdmin";
import UserHome from "./pages/UserFunctionality/UserHome";
import UpdateUser from "./pages/UserFunctionality/UpdateUser";
import TicketDetails from "./pages/UserFunctionality/TicketDetails";
import MyTransactions from "./pages/UserFunctionality/Transaction Hisotry";
import CancelTicket from "./pages/UserFunctionality/CancelTicket";
import ReviewTrain from "./pages/TicketConfirm/review";

const AuthorizeUser = () => {
  const loginStatus = sessionStorage["loginStatus"];
  return loginStatus == "1" ? <UserHome /> : <Home />;
  // if (loginStatus == '1') {
  //   return <Home />
  // } else {
  //   return <Signin />
  // }
};

function App() {
  return (
    <div className="container-fluid">
      <div class="row">
        <div class="col-12 p-0 m-0">
          <BrowserRouter>
            <Routes>
              <Route path="/" element={<AuthorizeUser />} />
              <Route path="/signin" element={<Signin />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/home" element={<Home />} />
              <Route path="/bookTicket" element={<BookTicket />} />
              <Route path="/adminHome" element={<AdminHome />} />
              <Route path="/addTrain" element={<AddTrain />} />
              <Route path="/scheduleTrain" element={<Scheduletrain />} />
              <Route path="/editTrain" element={<EditTrain />} />
              <Route path="/addAdmin" element={<AddAdmin />} />
              <Route path="/updateAdmin" element={<UpdateAdmin />} />
              <Route path="/userHome" element={<UserHome />} />
              <Route path="/updateUser" element={<UpdateUser />} />
              <Route path="/ticketDetails" element={<TicketDetails />} />
              <Route path="/mytrasnaction" element={<MyTransactions />} />
              <Route path="/cancelTicket" element={<CancelTicket />} />
              <Route path="/review" element={<ReviewTrain />} />
            </Routes>
          </BrowserRouter>
          <ToastContainer theme="colored" />
        </div>
      </div>
    </div>
  );
}

export default App;
