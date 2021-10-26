import './home.css'
import { Typography, Box, Grid, Button } from '@material-ui/core'

function Home() {
    return (
        <>
            <Grid container direction="row" justifyContent="center" alignItems="center" style={{ backgroundColor: "#3F51B5" }}>
                <Grid alignItems="center" item xs={6}>
                    <Box paddingX={20}>
                        <Typography variant="h3" gutterBottom color="textPrimary" component="h3" align="center" style={{ color: "white", fontWeight: "bold" }}>Seja bem vindo(a)</Typography>
                        <Typography variant="h5" gutterBottom color="textPrimary" component="h5" align="center" style={{ color: "white", fontWeight: "bold" }}>Expresse aqui os seus pensamentos e opiniões</Typography>
                    </Box>
                    <Box display="flex" justifyContent="center">
                        <Box marginRight={1}>
                        </Box>
                        <Button variant="outlined" style={{borderColor:"white", backgroundColor: "#3F51B5",color: "white"}}>Ver Postagens</Button>
                    </Box>
                </Grid>
                <Grid item xs={6}>
                    <img src="https://i.imgur.com/H88yIo2.png" alt=""  width="500px" height="500px" />
                </Grid>

                <Grid xs={12} style={{backgroundColor: "white"}}>
                </Grid>
            </Grid>
        </>
    );
}

export default Home;


/*
   <h1 className='titulo'>Home</h1>
   <img src="https://i.imgur.com/H88yIo2.png" alt="Imagem inicial"  className='img'/>
           <Grid container spacing={2}>
       <Grid item xs={12} sm={8}> 
           <Paper style={{ height: "100vh", background:"blue"}}/>
       </Grid>
       <Grid item container direction="column" xs={12} sm={4} spacing={2}>
           <Grid item> 
               <Paper style={{ height: "49vh", background:"orange"}}/>
           </Grid>
           
           <Grid item>
               <Paper style={{ height: "49vh", background:"green"}}/>
           </Grid>
       </Grid>
</Grid>   
   */