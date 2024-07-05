import axios from "axios";
import { useEffect, useState } from "react";
import "./styles/approveguide.css"
import { Button } from "../components/buttonComponent/Button";

export const ApproveGuidePage = () => {
    const [pendingGuides, setPendingGuides] = useState([]);
    const [isLoaded, setIsLoaded] = useState(false);

    const approveGuide = async (guideId: number) => {
        axios.put('http://localhost:8082/user/updateRole?id=' + guideId)
            .then((response) => {
                setIsLoaded(false);
            }).catch((error) => {
                console.log(error)
            })
    }

    const rejectGuide = async (guideId: number) => {
        axios.delete('http://localhost:8082/user/deleteUserById?id=' + guideId)
            .then((response) => {
                setIsLoaded(false);
            }).catch((error) => {
                console.log(error)
            })
    }

    const loadPendingGuides = async () => {
        await axios.get('http://localhost:8082/user/pendingUsers')
            .then((response) => {
                setPendingGuides(response.data)
            }).catch((error) => {
                console.log(error)
            })
    }

    if (!isLoaded) {
        loadPendingGuides();
        setIsLoaded(true);
    }


    return (
        <div className='route-create-container-outer'>
            <div className="route-create-container">
                <h1>Pending Guides</h1>
                <div className='pending-guides'>
                    {pendingGuides.map((guide: any, index: number) => {
                        return (
                            <div className='pending-guide' key={index}>
                                <h1 className="guide-text">{guide.emailUser}</h1>
                                <Button label='Approve' isEnabeld={true} size="medium" onClick={() => approveGuide(guide.id)} />
                                <Button label='Reject' isEnabeld={true} size="medium" onClick={() => rejectGuide(guide.id)} />
                            </div>
                        );
                    }
                    )}
                </div>
            </div>
        </div>
    );
}