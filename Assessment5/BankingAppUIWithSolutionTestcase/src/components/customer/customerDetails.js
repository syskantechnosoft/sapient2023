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
    console.log("Mounting in Customer Details Functional Component","data:",data1,"id:",id);
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
            <p>ID: {customer[0].id}</p>
            <p>FirstName: {customer[0].firstName}</p>
            <p>LastName: {customer[0].lastName}</p>
            <p>Email: {customer[0].email}</p>
            <p>Phone: {customer[0].mobile}</p>
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
