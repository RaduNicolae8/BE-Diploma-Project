import { useEffect } from 'react';



function RoleList() {
    useEffect(() => {
        fetch('http://localhost:8090/api/role', {
            method: 'GET',
            credentials: 'include'
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
            })
            .catch(error => console.error(error));
    }, []);

    return (
        <div>
            {/* your component UI goes here */}
        </div>
    );
}

export default RoleList;
