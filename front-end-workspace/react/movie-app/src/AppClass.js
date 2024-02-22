import React from "react";

class AppClass extends React.Component{
    constructor(props){
        super(props);
        console.log("constructor");
    }
    
    componentDidMount(){
        // 컴포넌트가 다 렌더링 되고 나면,
        console.log("component rendered-didmount");
    }
    componentDidUpdate(){
        console.log("I just updated");
    }
    componentWillUnmount(){
        console.log("GoodBye, React");
    }

    state = {
        count : 0,
    };
    add = ()=>{
        console.log('add');
        //this.state.count =1;
       // this.setState({count : 1});
        this.setState({count : this.state.count+ 1});
    };
    minus = () => {
        console.log('minus');
        //this.state.count =-1;
        this.setState({count : this.state.count-1});
    };
    
    render(){
        console.log("render");
        return (
            <div>
                <h1>This number is : {this.state.count}</h1>
                <button onClick={this.add}>Add</button>
                <button onClick={this.minus}>Minus</button>
            </div>
        );
    }
}
export default AppClass;