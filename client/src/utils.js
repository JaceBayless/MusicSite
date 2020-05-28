function getUrl( url ){
    return window.contextUrl ? window.contextUrl + url : '/' + url;
}

export default getUrl;