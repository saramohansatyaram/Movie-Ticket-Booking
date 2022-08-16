import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router';
import {Link} from 'react-router-dom';
import {Container,Paper} from 'react-bootstrap'

function Login() {
    const paperStyle={padding: '80px 30px', width:'500',backgroundColor:"white"}
    const [loginForm, setLoginForm] = useState({
        username: "",
        password: ""
    })
    const [role1, setRole] = useState("");
    const [formErrors, setFormErrors] = useState({});
    const navigate = useNavigate();
    const handleChange = (event) => {
        setLoginForm(loginForm => ({ ...loginForm, [event.target.name]: event.target.value }));
    }
    const handleSubmit = (event) => {
        //validation login form
        let errors = {};
        if (!loginForm.username) {
            errors["usernameErr"] = "Username is required"
        }
        if (!loginForm.password) {
            errors["passwordErr"] = "Password is required"
        }
        if (!role1) {
            errors["roleErr"] = "Role is required"
        }
        setFormErrors(errors);
        const noErrors = Object.keys(errors).length === 0;
        // if no errors call the login api
        if (noErrors) {



            let payload = {
                username: loginForm.username,
                password: loginForm.password,
                role: role1
            }
            axios.post("http://localhost:8085/auth/login", payload).then(resp => {
                console.log(resp.data);
                alert("Welcome " + resp.data.role);
                let user = {
                    customerId: resp.data.customerId,
                    customerName: resp.data.customerName,
                    role: resp.data.role
                }
                localStorage.setItem("myUser", JSON.stringify(user));



                if (resp.data.role === "customer") {
                    navigate("/CustomerMenuBar");



                }
                if (resp.data.role === "admin") {



                    navigate("/AdminMenuBar");



                }



            }).catch(error => {
                console.log(error.response);
                alert("Invalid Credentials");
            })
        }
        event.preventDefault();
    }
    const myStyle={
        backgroundImage:
        "url('https://img.freepik.com/free-vector/man-sitting-desk-unlocking-computer-computer-settings-login-flat-illustration_74855-20645.jpg?t=st=1652343984~exp=1652344584~hmac=5bb25b3a0769609b06d1367aae4486423709f5333a0abf8727b91efaa20cf991&w=740')",
        height:'100vh',
       // backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
    };
    return (
        <div style={myStyle}>
        <div style={{
            position: 'absolute', left: '70%', top: '50%',
            transform: 'translate(-50%, -50%)'
        }}>

          <Container style={paperStyle}> 

        <div class="row h-100 justify-content-center align-items-center">
            <div className='col-10 col-md-8 col-lg-12'>
                <div className='form-group'>
                    <label htmlFor='username'>Username</label>
                    <input type="text" name="username" id="username" className="form-control" value={loginForm.username} onChange={handleChange} />
                    {
                        formErrors.usernameErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.usernameErr}</div>
                    }
                </div>
                <div className='form-group'>
                    <label htmlFor='password'>Password</label>
                    <input type="password" name="password" id="password" className="form-control" value={loginForm.password} onChange={handleChange} />
                    {
                        formErrors.passwordErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.passwordErr}</div>
                    }
                </div>
                <div>
                    <input type="radio" id="role1" name="role1" value="customer" onChange={(e) => setRole("customer")}
                        checked={role1 === "customer"} /> Customer
                        
                    <input type="radio" id="role1" name="role1" value="admin" onChange={(e) => setRole("admin")}
                        checked={role1 === "admin"} /> Admin
                    {
                        formErrors.roleErr && <div style={{ color: "red", paddingBottom: 10 }}>{formErrors.roleErr}</div>
                    }
                    <p></p>
                </div>
                <div>
                    
                    <button onClick={handleSubmit} className="btn btn-primary">Login</button><br/>
                    <p></p>
                    Do u have an account? <a href="/createCustomer">REGISTER</a>
                      {/* <Link to="/createCustomer" ><button className="btn btn-primary"> Register</button></Link>  */}
                </div>
            </div>
        </div>
    </Container>
    </div>
    </div>

    )
}
export default Login;