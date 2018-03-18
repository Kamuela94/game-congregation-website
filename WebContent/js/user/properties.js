var config ={
    "protocol": "http",
    "port": "2222",
    "domain": "localhost",
    "project": "game-congregation-website"
}

function getURI() {
    return config.protocol + "://" + config.domain + ":" + config.port + "/" + config.project + "/api/";
}