import React, { useState, useEffect } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { Box, Card, CardActions, CardContent, Button, Typography } from '@material-ui/core'
import useLocalStorage from 'react-use-localstorage';
import { busca } from './../../../Services/Service';

import './ListaPostagem.css';
import Postagem from '../../../Models/Postagem';
function ListaPostagem() {
    
    const [Posts, setPosts] = useState<Postagem[]>([]);
    const [token, setToken] = useLocalStorage('token')
    let history = useHistory();

    useEffect(() => {
        if (token == "") {
            alert("você precisa estar logado")
           history.push("/login")
        }
    }, [token])

    async function getPosts(){
        await busca("/postagens", setPosts, {
          headers: {
            'Authorization': token
          }
        })
      }

    useEffect(() => {
        getPosts()
    }, [Posts.length])
    return (
        <>
        {
            Posts.map(post => (
            <Box m={2} >
                <Card variant="outlined">
                    <CardContent>
                        <Typography color="textSecondary" gutterBottom>
                            Postagens
                        </Typography>
                        <Typography variant="h5" component="h2">
                            {post.titulo}
                        </Typography>
                        <Typography variant="body2" component="p">
                            {post.texto}
                        </Typography>
                        <Typography variant="body2" component="p">
                            {post.tema?.descricao}
                        </Typography>
                    </CardContent>
                    <CardActions>
                        <Box display="flex" justifyContent="center" mb={1.5}>
                            <Link to={`/formularioPostagem/${post.id}`} className="text-decorator-none" >
                                <Box mx={1}>
                                    <Button variant="contained" className="marginLeft" size='small' color="primary">
                                        atualizar
                                    </Button>
                                </Box>
                            </Link>
                            <Link to={`/deletarPostagem/${post.id}`}className="text-decorator-none">
                                <Box mx={1}>
                                    <Button variant="contained" size='small' color="secondary">
                                        deletar
                                    </Button>
                                </Box>
                            </Link>
                        </Box>
                    </CardActions>
                </Card>
            </Box>
            ))}
        </>
    );
}
export default ListaPostagem;