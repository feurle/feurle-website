import React, { useEffect, useState } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

const ContentList = () => {

    const [contents, setContents] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('api/contents')
            .then(response => response.json())
            .then(data => {
                setContents(data);
                setLoading(false);
            })
    }, []);

    const remove = async (id) => {
        await fetch(`/api/content/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedContents = [...contents].filter(i => i.id !== id);
            setContents(updatedContents);
        });
    }

    if (loading) {
        return <p>Loading...</p>;
    }

    const contentList = contents.map(content => {
        const article = `${content.contentTitle || ''} ${content.contentText || ''} ${content.creationDate || ''}`;
        return <tr key={content.id}>
            <td style={{whiteSpace: 'nowrap'}}>{content.title}</td>
            <td>{article}</td>
            <td>
                <ButtonGroup>
                    <Button size="sm" color="primary" tag={Link} to={"/contents/" + content.id}>Edit</Button>
                    <Button size="sm" color="danger" onClick={() => remove(content.id)}>Delete</Button>
                </ButtonGroup>
            </td>
        </tr>
    });

    return (
        <div>
            <AppNavbar/>
            <Container fluid>
                <div className="float-end">
                    <Button color="success" tag={Link} to="/contents/new">Add Content</Button>
                </div>
                <h3>My JUG Tour</h3>
                <Table className="mt-4">
                    <thead>
                    <tr>
                        <th width="20%">Name</th>
                        <th width="20%">Location</th>
                        <th>Events</th>
                        <th width="10%">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {contentList}
                    </tbody>
                </Table>
            </Container>
        </div>
    );
};

export default ContentList;