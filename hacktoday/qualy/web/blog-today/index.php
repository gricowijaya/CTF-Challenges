<?php
class ViewPage
{
    public $file;

    public function __destruct() 
    {
        include($this->file);
    }
}

if (empty($_COOKIE['PHPSESSID']))
{
    $page = new ViewPage;
    $page->file = '/var/www/html/index.html';

    setcookie(
        'PHPSESSID', 
        base64_encode(serialize($page)), 
        strtotime( '+1 days' ), 
        '/'
    );
} 

$cookie = base64_decode($_COOKIE['PHPSESSID']);
unserialize($cookie);
