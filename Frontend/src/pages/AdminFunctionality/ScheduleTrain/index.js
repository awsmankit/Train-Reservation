// import { Link } from 'react-router-dom'
// import { useState } from 'react'
// import { toast } from 'react-toastify'
// import axios from 'axios'
// import { useNavigate } from 'react-router'
// import { URL } from '../../../config'

// const Scheduletrain=()=>{

//     const[ DayOfWeek , setTrainDayOfWeek ] = useState('')
//     const[ trainNo , setTrainNo ] = useState('')

//     const navigate = useNavigate()

//     const addcalendar = ()=>{
//         if (DayOfWeek.length == 0) {
//             toast.warning('Please select a day of the week')
//           } else if (trainNo.length == 0) {
//             toast.warning('Please enter TrainNo')

//           } else {
//             const body = {
//                 DayOfWeek,
//                 trainNo,

//             }

//             const url  = `${URL}/train/addtraincalendar`

//             axios.post(url,body).then((response)=>{
//                 const result = response.data

//                 if (result['status'] == 'success') {
//                     toast.success('Successfully added new train')

//                     // navigate to the adminHome page
//                     navigate('/adminHome')
//                   } else {
//                     toast.error(result['error'])
//                   }

//             })
//         }
//     }

//     const calculateDayOfWeek = (date) => {
//         const dayOfWeek = new Date(date).getDay();
//         const daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
//         return daysOfWeek[dayOfWeek];
//     }

//     return(
//         <div>
//             <h1 className="title">Schedule Train</h1>

//             <div className="row">
//                 <div className="col"></div>
//                 <div className="col">
//                     <div className="form">
//                         <div className="mb-3">
//                             <label htmlFor="" className="label-control">
//                                 Train Day of Week
//                             </label>
//                             <input
//                                 onChange={(e) => {
//                                     const dayOfWeek = calculateDayOfWeek(e.target.value);
//                                     setTrainDayOfWeek(dayOfWeek);
//                                 }}
//                                 type="date"
//                                 className="form-control"
//                             />
//                         </div>

//                         <div className="mb-3">
//                             <label htmlFor="" className="label-control">
//                                 TrainNo
//                             </label>
//                             <input
//                                 onChange={(e) => {
//                                     setTrainNo(e.target.value)
//                                 }}
//                                 type="text"
//                                 className="form-control"
//                             />
//                         </div>

//                         <div className="mb-3">
//                             <button onClick={addcalendar} className="btn btn-primary">
//                                 Add Calendar
//                             </button>
//                         </div>
//                     </div>
//                 </div>
//                 <div className="col"></div>
//             </div>
//         </div>
//     )
// }

// export default Scheduletrain

import { Link } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router";
import { URL } from "../../../config";
import Footer from "../../../components/Footer";
import Header from "../../../components/Header";

const Scheduletrain = () => {
  const [trainDate, setTrainDate] = useState("");
  const [trainNo, setTrainNo] = useState("");

  const navigate = useNavigate();

  const addcalendar = () => {
    if (trainDate.length == 0) {
      toast.warning("Please enter TrainDate");
    } else if (trainNo.length == 0) {
      toast.warning("Please enter TrainNo");
    } else {
      const body = {
        trainDate,
        trainNo,
      };

      const url = `${URL}/train/addtraincalendar`;

      axios.post(url, body).then((response) => {
        const result = response.data;

        if (result["status"] == "success") {
          toast.success("Successfully added new train");

          // navigate to the adminHome page
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
      <h1 className="title">Schedule Train</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="" className="label-control">
                TrainDate
              </label>
              <input
                onChange={(e) => {
                  setTrainDate(e.target.value);
                }}
                type="date"
                className="form-control"
                min={new Date().toISOString().split("T")[0]} // set the min attribute to the current date
              />
              {trainDate && (
                <label htmlFor="" className="label-control">
                  Day:{" "}
                  {new Date(trainDate).toLocaleDateString("en-US", {
                    weekday: "long",
                  })}
                </label>
              )}
            </div>

            <div className="mb-3">
              <label htmlFor="" className="label-control">
                TrainNo
              </label>
              <input
                onChange={(e) => {
                  setTrainNo(e.target.value);
                }}
                type="text"
                className="form-control"
              />
            </div>

            <div className="mb-3">
              <button onClick={addcalendar} className="btn btn-primary">
                Addcalendar
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
export default Scheduletrain;
