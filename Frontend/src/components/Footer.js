import React from "react";

const Footer = (props) => {
  return (
    <div>
      <footer class="bg-dark text-light py-2 bottom">
        <div class="container-fluid">
          <div class="row mb-3">
            <div class="col-md-6 mb-2">
              <p>&copy; 2023 SAFAR</p>
            </div>
            <div class="col-md-6 text-end">
              <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
            </div>
          </div>
        </div>
      </footer>
      <style>
        {`
        /* Set the position of the footer to fixed and keep it at the bottom */
        footer {
          position: absolute;
          bottom:0 ;
          height: 8%;
          width: 100%;
        }
        `}
      </style>
    </div>
  );
};

Footer.defaultProps = {
  title: " ",
};

export default Footer;
