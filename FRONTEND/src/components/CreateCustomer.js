import React, { useState } from 'react';
import axios from 'axios';
import {Container,Button} from 'react-bootstrap'
import { useNavigate } from 'react-router-dom';
import profileImg from '../components/images/profile.png'
// //import { CgProfile } from "react-icons/bs";
// import { CgProfile } from 'react-icons/cg';

var mobileTest="false";
    var emailTest="false";
function CreateCustomer() {
    const paperStyle={padding: '45px 30px', width:'500',backgroundColor:"white", borderRadius:20,}
    const [customer, setCustomer] = useState({
        customerName: "",
        email: "",
        mobile: "",
        address: "",
        // role:"",
        username: "",
        password: ""

    })
    
    const [formErrors, setFormErrors] = useState({});
    const handleChange = (event) => {
        setCustomer(customer => ({ ...customer, [event.target.name]: event.target.value }));
    }

    const emp = () => {
        let errors = {};
        errors['emailErr'] = ""
        setFormErrors(errors);
    }

    const navigate = useNavigate();
    const handleOnChange = (email) => {
        const re = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
        //const re=/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+))|("[\w-\s]+")([\w-]+(?:\.[\w-]+)))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i;
        if (re.test(email.target.value)) {
            emp();
            emailTest="true"
            handleChange(email);
            
        }
        else {
            handleChange(email);
            if (email.target.value === "") { emp(); }
            else {
                let errors = {};
                errors['emailErr'] = "email  is not correct"
                setFormErrors(errors);
            }
        }
    }
    const emp1 = () => {
        let errors = {};
        errors['mobileErr'] = ""
        setFormErrors(errors);
    }
    const handleOnMobile = (mobile) => {
        const re1 = /^([+]?[\s0-9]+)?(\d{3}|[(]?[0-9]+[)])?([-]?[\s]?[0-9])+$/i;
        const re=/^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/i;
        console.log(mobile.target.value);
        if (re.test(mobile.target.value)) {
            console.log("Success")
            emp1();
            mobileTest="true";
            handleChange(mobile);
        }
        else {
            handleChange(mobile);
            if (mobile.target.value === "") { emp1(); }
            else {
                let errors = {};
                errors['mobileErr'] = "Enter 10 digit mobile number"
                setFormErrors(errors);
            }
        }
    }

    const handleSubmit = () => {
        //validate form
        let errors = {};
        if (!customer.customerName) {
            errors['customerNameErr'] = "Customer Name is required";
        }
        if (!customer.email) {
            errors['emailErr'] = "email  is required"
        }
        if (!customer.mobile) {
            errors['mobileErr'] = "mobile is required"
        }
        console.log(emailTest);
        console.log(mobileTest);
        if(emailTest==="false")
        {
            errors['emailErr'] = "please enter correct Email ID"
        }
        if(mobileTest==='false')
        {
            errors['mobileErr'] = "please enter correct mobile"
        }
        
        if (!customer.address) {
            errors['addressErr'] = " address is required"
        }
        if (!customer.username) {
            errors['usernameErr'] = "username is required"
        }
        if (!customer.password) {
            errors['passwordErr'] = "password is required"
        }
        // if (!customer.role) {
        //     errors['roleErr'] = "role is required"
        // }


        setFormErrors(errors);
        const noErrors = Object.keys(errors).length === 0;
        if (noErrors) {
            const palyload = {
                username: customer.username,
                role: "customer",
                password: customer.password,
                customerName: customer.customerName,
                email: customer.email,
                mobile: customer.mobile,
                address: customer.address,
                

            }
            axios.post("http://localhost:8085/api/customer/add", palyload)
                .then(resp => {
                    alert(resp.data.role + " Registered Successfully Redirecting to login page..");
                    navigate('/');
                }).catch(error => {
                    alert("Customer Already Exists");
                })

        }
    }
    const myStyle={
        backgroundImage:
        "url('https://free4kwallpapers.com/uploads/originals/2016/01/03/iguacu-falls-nexus-6p-wallpaper.jpg')",
        height:'100vh',
       backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
    };
    return (
        <div style={myStyle}>
        <div style={{
            position: 'absolute', left: '50%', top: '50%',
            transform: 'translate(-50%, -50%)'
        }}>

          <Container style={paperStyle}> 
        <div >
        <center> <img src={profileImg} alt="Profile" width="50" height="50" ></img> </center> <p></p>
        <center><h1 style={{fontSize:"20px"}}>Enter details to register</h1></center><p></p>
             <div>
             {/* <label>Enter Username</label> */}
                <input type="text" name="username"  value={customer.username} onChange={handleChange} placeholder="Username"   className="form-control" />
                {
                    formErrors.usernameErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.usernameErr}</div>
                }
            </div>
            

            <div>
                {/* <label>Password</label> */}
                <input type="password" name="password" value={customer.password} onChange={handleChange} placeholder="Password"  className="form-control"/>
                {
                    formErrors.passwordErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.passwordErr}</div>
                }
            </div>
            <div>
                {/* <label>Customer Name</label> */}
                <input type="text" name="customerName" value={customer.customerName} onChange={handleChange} placeholder="Customer Name"  className="form-control"/>
                {
                    formErrors.customerNameErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.customerNameErr}</div>
                }
            </div>
            <div>
                {/* <label>Email</label> */}
                <input type="text" name="email" onChange={handleOnChange} placeholder="Email ID"  className="form-control"/>
                {
                    formErrors.emailErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.emailErr}</div>
                }
            </div>
            <div>
                {/* <label>Mobile</label> */}
                <input type="number" name="mobile" onChange={handleOnMobile} placeholder="Mobile Number"  className="form-control" />
                {
                    formErrors.mobileErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.mobileErr}</div>
                }
            </div>
            <div>
                {/* <label>Address</label> */}
                <input type="text" name="address" value={customer.address} onChange={handleChange} placeholder="Address"  className="form-control"/>
                {
                    formErrors.addressErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.addressErr}</div>
                }
            </div>
           
            {/* <div>
                <label>Role</label>
                <input type="role" name="role" value={customer.role} onChange={handleChange} />
                {
                    formErrors.roleErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.roleErr}</div>
                }
            </div> */}


            <div>
                <p></p>
                {/* <button onClick={handleSubmit}>Submit</button> */}
                <Button variant="dark" onClick={handleSubmit}>SIGNUP</Button>
                {/* <button onClick={() => { window.location.href = "/" }}> Login</button> */}
            </div>
        </div>
        </Container>
    </div>
    </div>
    )
}
export default CreateCustomer;