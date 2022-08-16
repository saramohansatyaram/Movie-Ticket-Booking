import React from 'react'
import {Navbar,Container,Nav,Button} from 'react-bootstrap'
import { useNavigate } from 'react-router'
// import bgimage from '../images/bgimage.png';
const CustomerMenuBar = () => {



const navigate=useNavigate();
const logout=()=>{
navigate("/");
}
// const myStyle={
// backgroundImage:
// `url(${bgimage})`,
// height:'100vh',
// backgroundSize: 'cover',
// backgroundRepeat: 'no-repeat',
// };
const myStyle={
    backgroundImage:
    "url('https://akm-img-a-in.tosshub.com/indiatoday/images/story/201904/bookmyshow.jpeg?Qw2s1hm0KqX0icR1_WjtzSLE19lTaoOp&size=770:433')",
    height:'100vh',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat',
};



return (
<div style={myStyle}>


<Navbar bg="primary" variant="dark">
<Container>
<Navbar.Brand >Customer</Navbar.Brand>
<Nav className="me-auto">
<Nav.Link href="/customermovies">Movie List</Nav.Link>
<Nav.Link href="/customertheater">Theatre Details</Nav.Link>
<Nav.Link href="/customertimings">Theatre Timings</Nav.Link>
<Nav.Link href="/customershows">customer Shows</Nav.Link>
<Nav.Link href="/addbooking">AddBooking</Nav.Link>
</Nav>
</Container>
<Button variant="primary" onClick={logout}>Logout</Button>
</Navbar>



<br />




</div>
)
}



export default CustomerMenuBar