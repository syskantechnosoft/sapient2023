import React, { useState,useEffect } from "react";
import { Link } from "react-router-dom";
import customerArray from '../../model/customer.json';
import {useParams} from 'react-router-dom';
import AccountList from "../account/accountList";

const CustomerDetails = () => {
  const [customer, setCustomer] = useState({ id: 0 }); //const customer = this.state.customer
  const backLineText = "< Back to Customers List";
  const params = useParams();
  const id = params.id!==0?params.id:1;
  useEffect(()=>{
    //You can add your code here for mounting phase of component
    // let data =customerArray.filter(cust=>{ (cust.id==id)? console.log("customer found with ID!!",cust.id):console.log("customer Not found!!")});
    let data1 = customerArray.filter(cus=>cus.id==id);
    setCustomer(data1);
},[id]);
  function getCustomerDetailsDiv() {
    return (
      <div>
        <div className="row">
          <Link color="primary" to="/">
            {backLineText}
          </Link>
        </div>
        <div className="row">
          <div className="col-md-4">
            <h4>Customer Details</h4>
            <hr />
            {/* Add missing code to display customer details*/}
            <p>ID: </p>
            <p>FirstName: </p>
            <p>LastName: </p>
            <p>Email: </p>
            <p>Phone:</p>
          </div>
          <div className="col-md-8">
            <AccountList customerId={customer[0].id} />
          </div>
        </div>
      </div>
    );
  }

  return (
    <div>
      Customer Details!!!
      <div>{customer.id !== 0 ? getCustomerDetailsDiv() : null}</div>
    </div>
  );
};

export default CustomerDetails;
