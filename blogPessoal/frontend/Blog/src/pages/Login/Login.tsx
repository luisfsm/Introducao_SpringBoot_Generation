import React,{ChangeEvent, useState, useEffect }from 'react'
import { Grid, Box, Typography, TextField, Button } from '@material-ui/core';
import useLocalStorage from 'react-use-localstorage';
import { Link, useHistory } from 'react-router-dom';
import './Login.css';
import UserLogin from './../../Models/UserLogin';
import { login } from './../../Services/Service';

function Login() {

    let history = useHistory();
    const [token,setToken] = useLocalStorage('token');

    const[userLogin, setUserLogin] = useState<UserLogin>({
        id: 0,
        usuario:'',
        senha: '',
        token:''
    })

    function updatedModel(e:ChangeEvent<HTMLInputElement>){
        setUserLogin({
            ...userLogin,
            [e.target.name] : e.target.value
        })

    }

    useEffect(()=>{
      if(token !=""){
        history.push("/home")
      }  
    },[token])

    async function onSubmit(e:ChangeEvent<HTMLFormElement>){
        e.preventDefault();
        try{
            await login(`/usuarios/logar`,userLogin,setToken)
            
            alert("usuario autenticado")

        }catch(e){
            alert("dados inconsistentes, erro ao logar "+e)

        }
    } 

    return (
        <Grid container direction="row" justifyContent="center" alignItems="center">
            <Grid xs={6} alignItems="center">
                <Box paddingX={20}>
                    <form onSubmit={onSubmit}>
                        <Typography variant="h3" gutterBottom color="textPrimary" component="h3" align="center" className="textos1" >Entrar</Typography>
                        <TextField value={userLogin.usuario} onChange={(e:ChangeEvent<HTMLInputElement>) => updatedModel(e)}  id="usuario" label="usuario" variant="outlined" name="usuario" margin="normal" fullWidth />
                        <TextField value={userLogin.senha} onChange={(e:ChangeEvent<HTMLInputElement>) => updatedModel(e)} id="senha" label="senha" variant="outlined" name="senha" margin="normal" fullWidth type="password" />
                        <Box marginTop={2} textAlign="center">
                          
                                <Button color="primary" type="submit" variant="contained" >
                                    Logar
                                </Button>
                        
                        </Box>
                    </form>
                    <Box display="flex" justifyContent="center" marginTop={2}>
                        <Box marginRight={1}>
                            <Typography variant="subtitle1" gutterBottom align="center">Não tem conta?</Typography>
                        </Box>
                      
                        <Link to="signup">
                            <Typography variant="subtitle1" gutterBottom align="center" className="textos1">Cadastre-se</Typography>
                        </Link>
                    </Box>
                </Box>
            </Grid>
            <Grid xs={6} className="imgLogin">

            </Grid>
        </Grid>
    )
}

export default Login
